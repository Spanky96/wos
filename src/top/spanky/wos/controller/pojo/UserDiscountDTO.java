package top.spanky.wos.controller.pojo;

import top.spanky.wos.model.Discount;
import top.spanky.wos.model.UserDiscount;

public class UserDiscountDTO {

    private int id;
    private String name;
    private String description;
    private double disPrice;
    private double restrictPrice;
    private int type;
    private long timeStart;
    private long timeOver;
    private boolean isUsed;

    public UserDiscountDTO(Discount discount, UserDiscount userDiscount) {
        this.id = userDiscount.getId();
        this.name = discount.getName();
        this.description = discount.getDescription();
        this.disPrice = discount.getDisPrice();
        this.restrictPrice = discount.getRestrictPrice();
        this.type = discount.getType();
        this.timeStart = userDiscount.getTimeStart().getTime();
        this.timeOver = userDiscount.getTimeOver().getTime();
        this.isUsed = userDiscount.isUsed();
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

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public long getTimeOver() {
        return timeOver;
    }

    public void setTimeOver(long timeOver) {
        this.timeOver = timeOver;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }


}
