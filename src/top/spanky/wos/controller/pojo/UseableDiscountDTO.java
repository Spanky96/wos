package top.spanky.wos.controller.pojo;

import top.spanky.wos.model.Discount;

public class UseableDiscountDTO {
    private int id;
    private String name;
    private String description;
    private double disPrice;
    private double restrictPrice;
    private int type;

    public UseableDiscountDTO(Discount discount, int id) {
        this.id = id;
        this.name = discount.getName();
        this.description = discount.getDescription();
        this.disPrice = discount.getDisPrice();
        this.restrictPrice = discount.getRestrictPrice();
        this.type = discount.getType();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(double disPrice) {
        this.disPrice = disPrice;
    }

    public double getRestrictPrice() {
        return restrictPrice;
    }

    public void setRestrictPrice(double restrictPrice) {
        this.restrictPrice = restrictPrice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}