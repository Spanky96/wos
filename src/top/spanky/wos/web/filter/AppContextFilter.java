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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import top.spanky.wos.AppContext;
import top.spanky.wos.Constants;
import top.spanky.wos.model.User;

public class AppContextFilter implements Filter {

    private final Logger logger = Logger.getLogger(AppContextFilter.class);
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        AppContext appContext = AppContext.getAppContext();
        AppContext.setContextPath(request.getContextPath());
        // TODO
        System.out.println("AppContextFilter|" + request.getRequestURI());
        HttpSession session = request.getSession();
        appContext.addObject(Constants.APP_CONTEXT_SESSION, session);
        User user = (User) session.getAttribute("USER");
        appContext.addObject(Constants.APP_CONTEXT_USER, user);
        try{
            chain.doFilter(request, response);
        } catch(IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (ServletException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            appContext.clear();
        }

    }

    @Override
    public void destroy() {
    }
}
