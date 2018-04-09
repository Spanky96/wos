package top.spanky.wos.controller.pojo;

import top.spanky.wos.controller.resource.CartList;

public class CartListDTO extends CartList {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
