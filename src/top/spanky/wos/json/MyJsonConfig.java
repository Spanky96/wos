package top.spanky.wos.json;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class MyJsonConfig {
    private static JsonConfig jsonConfig;
    private static DecimalFormat decimalFormat;
    // 持久的jsonconfig 对象
    // 隐藏 password 属性
    // 时间统一返回long
    static {
        jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[] { "password" });
        decimalFormat = new DecimalFormat("#.00");
        jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class, new JsonValueProcessor() {

            @Override
            public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
                return ((Timestamp) arg1).getTime();
            }

            @Override
            public Object processArrayValue(Object arg0, JsonConfig arg1) {
                return null;
            }
        });
    }

    private MyJsonConfig() {}

    public static JsonConfig getMyJsonConfig() {
        return jsonConfig;
    }
}
