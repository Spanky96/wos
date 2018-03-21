package top.spanky.wos.util;

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
}
