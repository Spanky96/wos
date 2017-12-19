package top.spanky.wos.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.spanky.wos.util.StringUtil;
import top.spanky.wx4j.pojo.SNSUserInfo;
import top.spanky.wx4j.pojo.WeixinOauth2Token;
import top.spanky.wx4j.util.AdvancedUtil;

public class DebugFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        if (StringUtil.isEmpty(code)) {
            // 跳转到index.jsp
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
