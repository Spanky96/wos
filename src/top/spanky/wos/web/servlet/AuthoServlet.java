package top.spanky.wos.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.spanky.wos.util.StringUtil;
import top.spanky.wx4j.pojo.SNSUserInfo;
import top.spanky.wx4j.pojo.WeixinOauth2Token;
import top.spanky.wx4j.util.AdvancedUtil;

/**
 * Servlet implementation class AuthoServlet
 */
public class AuthoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        System.out.println(code);
        if (StringUtil.isEmpty(code)) {
            // 跳转到index.jsp
            System.out.println(request.getContextPath());
            request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
            return;
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
            request.setAttribute("snsUserInfo", snsUserInfo);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
