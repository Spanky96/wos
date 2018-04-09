package top.spanky.wos.model;

import java.sql.Timestamp;

public class OrderHistory {

    public static final int PAY_SUCCESS = 0;
    public static final int ORDER_CLOSED = 1;
    public static final int BUSINESS_CONFIRM = 2;
    public static final int DISTRIBUTING = 3;
    public static final int ARRIVED = 4;
    public static final int DONE = 5;
    public static final int RATED = 6;

    private Integer id;
    private Integer orderId;
    private Timestamp time;
    private Integer type;
    private String phone;

    public OrderHistory() {
    }

    public OrderHistory(Integer orderId, Integer type, String phone) {
        this.orderId = orderId;
        this.type = type;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
