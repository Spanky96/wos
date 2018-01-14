package top.spanky.wos.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static Properties properties = null;

    static {
        InputStream in = ExceptionPropertyUtil.class.getClassLoader().getResourceAsStream("app.properties");
        properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
