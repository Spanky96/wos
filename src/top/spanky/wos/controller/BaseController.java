package top.spanky.wos.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import top.spanky.wos.AppContext;
import top.spanky.wos.Constants;
import top.spanky.wos.controller.resource.BasicResponse;
import top.spanky.wos.model.User;
import top.spanky.wos.util.PathUtil;
import top.spanky.wos.util.SessionUtil;

public abstract class BaseController {

    private final Logger logger = Logger.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        e.printStackTrace();
        logger.error(e.getMessage(), e);
        ModelAndView modelAndview = new ModelAndView(new RedirectView(AppContext.getContextPath() + "/static/500.html"));
        return modelAndview;
    }

    protected User getUser() {
        return AppContext.getAppContext().getUser();
    }

    public String getUserName() {
        User user = getUser();
        if (user != null)
            return user.getUsername();
        return "";
    }

    public int getUserId() {
        User user = getUser();
        if (user != null)
            return user.getId();
        return -1;
    }

    protected RedirectView getRedirectView(String path) {
        return new RedirectView(PathUtil.getFullPath(path));
    }

    protected void addSession(String key, Object object) {
        SessionUtil.addSession(key, object);
    }

    protected Object getSession(String key) {
        return SessionUtil.getSession(key);
    }

    protected void removeSession(String key) {
        SessionUtil.removeSession(key);
    }

    protected void invalidate() {
        SessionUtil.invalidate();
    }

    protected BasicResponse SUCCESS = new BasicResponse(Constants.RESPONSE_SUCCESS_VALUE,
            Constants.RESPONSE_SUCCESS_MESSAGE);
    protected BasicResponse FAIL = new BasicResponse(Constants.RESPONSE_FAIL_VALUE, Constants.RESPONSE_FAIL_MESSAGE);
    protected BasicResponse REJECT = new BasicResponse(Constants.RESPONSE_REJECT_VALUE,
            Constants.RESPONSE_REJECT_MESSAGE);
    protected BasicResponse EXCEPTION = new BasicResponse(Constants.RESPONSE_EXCEPTION_VALUE,
            Constants.RESPONSE_EXCEPTION_MESSAGE);
}
