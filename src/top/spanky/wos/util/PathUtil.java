package top.spanky.wos.util;

import top.spanky.wos.AppContext;
import top.spanky.wos.Constants;

public class PathUtil {

    public static String getFullPath(String path) {
        if (path == null) {
            path = "";
        }
        String urlPrefix = Constants.APP_URL_PREFIX;
        if (!StringUtil.isEmpty(urlPrefix)) {
            urlPrefix += "/";
        }
        // weixin / page/ 'path'
        return AppContext.getContextPath() + "/" + urlPrefix  + path;
    }

}

