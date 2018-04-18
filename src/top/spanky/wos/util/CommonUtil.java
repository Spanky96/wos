package top.spanky.wos.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import top.spanky.wos.controller.resource.CartList;

public class CommonUtil {
    public static String toCartstr(List<CartList> cartList) {
        StringBuffer buff = new StringBuffer();
        for (CartList item : cartList) {
            buff.append(item.getId() + "#" + item.getNumber() + "^");
        }
        return buff.toString();
    }

    public static long getTodaysLastSecond() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(getTodayStr() + " 23:59:59").getTime();
        } catch (ParseException e) {
        }
        return 0;
    }

    public static String getTodayStr() {
        return new Date(System.currentTimeMillis()).toString();
    }
}
