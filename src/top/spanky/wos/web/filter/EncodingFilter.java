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

public class EncodingFilter implements Filter{

    private String urlEncode;
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        urlEncode = "utf-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servltResponse, FilterChain filterChain) throws IOException,
    ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servltResponse;
        request.setCharacterEncoding(urlEncode);
        response.setContentType("text/html;charset=" + urlEncode);
        request.setCharacterEncoding(urlEncode);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
