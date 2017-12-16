package top.spanky.wos;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.spanky.wos.model.User;


public class AppContext {

    //private static Map<Thread, AppContext> appContextMap = new HashMap<Thread, AppContext>();

    private static ThreadLocal<AppContext> appContextMap = new ThreadLocal<AppContext>();
    private Map<String, Object> objects = new HashMap<String, Object>();
    private static String contextPath;

    private AppContext(){}

    public static AppContext getAppContext() {
        AppContext appContext = appContextMap.get();
        if (appContext == null) {
            appContext = new AppContext();
            appContextMap.set(appContext);
        }
        return appContextMap.get();

    }

    public Map<String, Object> getObjects() {
        return objects;
    }

    public Object getObject(String key) {
        return objects.get(key);
    }

    public void addObject(String key, Object object) {
        if (objects == null) {
            objects = new HashMap<String, Object>();
        }
        objects.put(key, object);
    }

    public void clear() {
        objects.clear();
    }

    public HttpServletRequest getHttpResquest() {
        return (HttpServletRequest) objects.get(Constants.APP_CONTEXT_REQUEST);
    }

    public HttpServletResponse getHttpResponse() {
        return (HttpServletResponse) objects.get(Constants.APP_CONTEXT_RESPONSE);
    }

    public Object removeObject(String key) {
        return objects.remove(key);
    }

    public static String getContextPath() {
        return contextPath;
    }

    public static void setContextPath(String contextPath) {
        if (AppContext.contextPath == null) {
            AppContext.contextPath = contextPath;
        }
    }
    
    public void setUser(User user) {
    		this.addObject("USER", user);
    }
    
    public User getUser() {
    		return (User)getObject("USER");
    		
    }
    
    public int getUserId() {
    		User user = getUser();
    		return user == null ? -1 : user.getId();
    }

}