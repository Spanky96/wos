package top.spanky.wos.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExceptionPropertyUtil {

    private static Properties properties = null;

    static {
        InputStream in = ExceptionPropertyUtil.class.getClassLoader().getResourceAsStream("exception.properties");
        properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getExcpetionMessage(int id) {
        String value = properties.getProperty(id + "");
        return value == null ? "Unkown excpetion." : value;
    }


}
