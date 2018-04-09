package top.spanky.wos.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import top.spanky.wos.Constants;
import top.spanky.wos.json.MyJsonService;
import top.spanky.wos.model.User;
import top.spanky.wos.service.UserService;
import top.spanky.wos.util.PropertyUtil;
import top.spanky.wos.util.SpringUtil;
import top.spanky.wos.util.StringUtil;
import top.spanky.wx4j.message.resp.TextMessage;
import top.spanky.wx4j.pojo.SNSUserInfo;
import top.spanky.wx4j.pojo.WeixinOauth2Token;
import top.spanky.wx4j.util.AdvancedUtil;
import top.spanky.wx4j.util.MessageUtil;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class UserController extends BaseController {

    private final Logger logger = Logger.getLogger(UserController.class);
    private final String LOGIN_JSP = "login";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dev", method = RequestMethod.GET)
    @ResponseBody
    public String devConfig(HttpServletRequest request) {
        return request.getParameter("echostr");
    }

    @RequestMapping(value = "/dev", method = RequestMethod.POST)
    @ResponseBody
    public String dev(HttpServletRequest request) {
        Map<String, String> requestMap = null;
        try {
            requestMap = MessageUtil.parseXml(request);
        } catch (Exception e) {
            logger.error("valid request");
            e.printStackTrace();
            return null;
        }

        for (String key : requestMap.keySet()) {
            System.out.println(key + "\t" + requestMap.get(key));
        }
        return doReply(requestMap);
    }

    private String doReply(Map<String, String> requestMap) {
        String MsgType = requestMap.get("MsgType");
        if (StringUtil.isEmpty(MsgType))
            return null;
        if (MsgType.toLowerCase().equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT))
            return replyText(requestMap);
        else if (MsgType.toLowerCase().equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT))
            return replyEvent(requestMap);
        return null;
    }

    private String replyText(Map<String, String> requestMap) {
        String content = requestMap.get("Content");
        TextMessage tm = new TextMessage();
        tm.setFromUserName(requestMap.get("ToUserName"));
        tm.setCreateTime(new Date().getTime() / 1000);
        tm.setToUserName(requestMap.get("FromUserName"));
        tm.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        if (content.trim().endsWith("红包")) {
            tm.setContent("一个红包已悄悄送到。可以去个人中心查看。");
            tm.setContent("今天您已经领取过红包啦，别太贪心噢～");
        } else {
            tm.setContent(TextMessage.defaultMessage[(int) (Math.random() * 6)]);
        }
        return MessageUtil.messageToXml(tm);

    }

    private String replyEvent(Map<String, String> requestMap) {
        String eventType = requestMap.get("Event");
        if (StringUtil.isEmpty(eventType))
            return null;
        if (eventType.toLowerCase().equals(MessageUtil.EVENT_TYPE_SCAN))
            return null;

        if (eventType.toLowerCase().equals(MessageUtil.EVENT_TYPE_CLICK)) {
            String eventKey = requestMap.get("EventKey");
            TextMessage tm = new TextMessage();
            tm.setFromUserName(requestMap.get("ToUserName"));
            tm.setCreateTime(new Date().getTime() / 1000);
            tm.setToUserName(requestMap.get("FromUserName"));
            tm.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
            if ("RED_PACKAGE".equals(eventKey)) {
                tm.setContent("一个红包已悄悄送到。可以去个人中心查看。");
            }
            if ("ABOUT".equals(eventKey)) {
                MyJsonService js = (MyJsonService) SpringUtil.getBean("myJsonService");
                tm.setContent(js.getShopBasicInfo().getJSONObject("seller").getString("bulletin"));
            }
            if ("ADVICE".equals(eventKey)) {
                tm.setContent("小滨觉得所有都是商品佳肴，无法推荐。😝开个玩笑，美食攻略会出的。对了悄悄告诉你，回复【我要红包】可以得到一个红包喔，每天都可以。不要说是我说的哦，这是个秘密😁！");
            }
            return MessageUtil.messageToXml(tm);
        }

        else if (eventType.toLowerCase().equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
            TextMessage tm = new TextMessage();
            tm.setFromUserName(requestMap.get("ToUserName"));
            tm.setCreateTime(new Date().getTime() / 1000);
            tm.setToUserName(requestMap.get("FromUserName"));
            tm.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
            tm.setContent(
                    "终于等到你，我是小滨，滨江厨房的智能机器人。选择左下角【滨江厨房】-【我要点餐】就能开始点餐啦。推荐注册会员，一切免费，享受更多更贴心的功能。");
            return MessageUtil.messageToXml(tm);
        }
        return null;
    }

    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    public ModelAndView autho(@RequestParam(value = "code", defaultValue = "") String code) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("code:" + code);// TODO
        if (StringUtil.isEmpty(code) || "authdeny".equals(code)) {
            logger.info("非法访问或用户拒绝");
            return null;
        } else {
            String APPID = PropertyUtil.get("appid");
            String SECRET = PropertyUtil.get("secret");
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APPID, SECRET, code);
            if (weixinOauth2Token == null) {
                logger.info("获取失败");
                return null;
            }
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            modelAndView.addObject("snsUserInfo", snsUserInfo);
            modelAndView.setViewName("index");
            // 跳转到index.jsp
            return modelAndView;
        }
    }

    @RequestMapping(value = "/oauth2", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap testAutho(@RequestParam(value = "code", defaultValue = "") String code) {
        ModelMap modelMap = new ModelMap();
        System.out.println("code" + code); // TODO
        if (StringUtil.isEmpty(code) || "authdeny".equals(code) || "1".equals(code)) {
            // logger.info("非法访问或用户拒绝");
            // return null;
            //////
            SNSUserInfo snsUserInfo = new SNSUserInfo();
            snsUserInfo.setCity("无锡");
            snsUserInfo.setCountry("中国");
            snsUserInfo.setHeadImgUrl(
                    "http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83equNEXayYjYkuTB6eP5Mfs6O2sw3a1A4MhtbNia6gCicCSQkoHjnICJrlWN4SYqtB9KC5wgKVD3eZJg/132");
            snsUserInfo.setNickname("Spanky Yym");
            snsUserInfo.setOpenId("testopenId");
            snsUserInfo.setProvince("江苏");
            snsUserInfo.setSex(1);
            modelMap.put("snsUserInfo", snsUserInfo);
            if ("1".equals(code)) {
                modelMap.put("redirect", "register");
            } else {
                User user = userService.getByOpenid("testopenId");
                snsUserInfo.setUser(user);
                modelMap.put("redirect", "sell");
            }
            return modelMap;
        }
        String APPID = "APPID";
        String SECRET = "SECRET";
        APPID = PropertyUtil.get("appid");
        SECRET = PropertyUtil.get("secret");
        // 获取网页授权access_token
        WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APPID, SECRET, code);
        if (weixinOauth2Token == null) {
            logger.info("获取失败");
            modelMap.put("redirect", FAIL.getMessage());
            return modelMap;
        }
        // 网页授权接口访问凭证
        String accessToken = weixinOauth2Token.getAccessToken();
        // 用户标识
        String openId = weixinOauth2Token.getOpenId();
        // 获取用户信息
        SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
        System.out.println(snsUserInfo);
        User user = userService.getByOpenid(snsUserInfo.getOpenId());
        if (user == null) {
            modelMap.put("redirect", "register");
        } else {
            snsUserInfo.setUser(user);
            modelMap.put("redirect", "sell");
        }
        // 设置要传递的参数
        modelMap.put("snsUserInfo", snsUserInfo);

        return modelMap;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "go", defaultValue = "") String go) {
        User user = this.getUser();
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.setView(this.getRedirectView("dashboard"));
        } else {
            modelAndView.addObject("go", go);
            modelAndView.setViewName(LOGIN_JSP);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doRegister(@RequestBody String userStr) {
        JSONObject obj = JSONObject.fromObject(userStr);
        User user = (User) JSONObject.toBean(obj, User.class);
        ModelMap modelMap = new ModelMap();
        //// TEST CODE
        if ("testopenId".equals(user.getOpenid())) {
            modelMap.put("result", SUCCESS);
            user.setId(5);
            modelMap.put("user", user);
            return modelMap;
        }
        //////
        boolean result = userService.addUserByWX(user);
        if (result) {
            modelMap.put("result", SUCCESS);
            modelMap.put("user", user);
        } else {
            modelMap.put("result", FAIL);
        }
        return modelMap;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doUpdate(@RequestBody String userStr) {
        JSONObject obj = JSONObject.fromObject(userStr);
        User user = (User) JSONObject.toBean(obj, User.class);
        ModelMap modelMap = new ModelMap();
        boolean result = userService.updateWxUser(user);
        if (result) {
            modelMap.put("result", SUCCESS);
        } else {
            modelMap.put("result", FAIL);
        }
        return modelMap;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(this.getRedirectView("content/question"));
        return modelAndView;
    }

}
