package top.spanky.wos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    private final String LOGIN_JSP = "login";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/autho", method = RequestMethod.GET)
    public ModelAndView autho(@RequestParam(value = "code", defaultValue = "") String code) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(code);
        if (StringUtil.isEmpty(code)) {
            // 跳转到index.jsp
            modelAndView.setViewName("index");
            return modelAndView;
        }
        // 用户同意授权
        if (!"authdeny".equals(code)) {
            String APPID = "APPID";
            String SECRET = "SECRET";
            APPID = "wx107ce995902d1e0b";
            SECRET = "efe75778beabfdd1afe1118638d22af8";
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APPID, SECRET, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            modelAndView.addObject("snsUserInfo", snsUserInfo);
            modelAndView.setViewName("index");

        }
        // 跳转到index.jsp
        return modelAndView;
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

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(this.getRedirectView("content/question"));
        return modelAndView;

    }

}
