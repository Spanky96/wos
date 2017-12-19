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

import top.spanky.wos.AppContext;
import top.spanky.wos.model.User;
import top.spanky.wos.util.PathUtil;
import top.spanky.wos.util.StringUtil;

public class SessionFilter implements Filter {

    private String notNeedLoginPage;
    protected FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        if (filterConfig.getInitParameter("notNeedLoginPage") != null) {
            notNeedLoginPage = filterConfig.getInitParameter("notNeedLoginPage");
        } else {
            notNeedLoginPage = "";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        String requestUri = uri.substring(request.getContextPath().length() + 1);
        String [] pages = notNeedLoginPage.split(",");
        boolean isAllow = false;
        for (String page : pages) {
            if (page.equals(requestUri)){
                isAllow = true;
                break;
            }
        }

        if (isAllow) {
            filterChain.doFilter(request, response);
        } else {
            User user = AppContext.getAppContext().getUser();
            if (user == null) {
                if (request.getMethod().toLowerCase().equals("get")) {
                    String queryString = request.getQueryString();
                    String go = requestUri;
                    if (!StringUtil.isEmpty(queryString)) {
                        go = go + "#" + request.getQueryString();
                    }
                    response.sendRedirect(PathUtil.getFullPath("login?go=" + go));
                } else {
                    response.sendRedirect(request.getContextPath() + "/page/login");
                }

            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

}
