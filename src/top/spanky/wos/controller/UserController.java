package top.spanky.wos.controller;

import java.util.Date;

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

import top.spanky.wos.Constants;
import top.spanky.wos.model.User;
import top.spanky.wos.service.UserService;
import top.spanky.wos.util.StringUtil;
import top.spanky.wx4j.pojo.SNSUserInfo;
import top.spanky.wx4j.pojo.WeixinOauth2Token;
import top.spanky.wx4j.util.AdvancedUtil;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class UserController extends BaseController {

    private final Logger logger = Logger.getLogger(UserController.class);
    private final String LOGIN_JSP = "login";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    public ModelAndView autho(@RequestParam(value = "code", defaultValue = "") String code) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(code);// TODO
        if (StringUtil.isEmpty(code) || "authdeny".equals(code)) {
            logger.info("非法访问或用户拒绝");
            return null;
        } else {
            String APPID = "APPID";
            String SECRET = "SECRET";
            APPID = "wx107ce995902d1e0b";
            SECRET = "efe75778beabfdd1afe1118638d22af8";
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
        System.out.println("code:" + code); // TODO
        SNSUserInfo snsUserInfo = new SNSUserInfo();
        snsUserInfo.setNickname("Spanky Yang");
        // oh56I1vlzWwbJ4SeS4STPyqbPAns
        snsUserInfo.setOpenId("oh56I1vlzWwbJ4SeS4STPyqbPAns");
        snsUserInfo.setSex(1);
        User user = userService.getByOpenid("oh56I1vlzWwbJ4SeS4STPyqbPAns");
        if (user == null) {
            modelMap.put("redirect", "register");
        } else {
            modelMap.put("redirect", "sell");
        }
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doRegister(@RequestBody User user) {

        System.out.println(user);
        ModelMap modelMap = new ModelMap();
        modelMap.put("user", new User());
        return modelMap;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(this.getRedirectView("content/question"));
        return modelAndView;

    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
    }

}
