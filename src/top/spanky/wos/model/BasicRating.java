package top.spanky.wos.model;

import java.sql.Timestamp;

public class BasicRating extends DisplayInfo {
    private Integer id;
    private Integer userId;
    private String text;
    private Timestamp rateTime;
    private Integer rateType; // 1: 好评 0:差评

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Timestamp getRateTime() {
        return rateTime;
    }
    public void setRateTime(Timestamp rateTime) {
        this.rateTime = rateTime;
    }
    public Integer getRateType() {
        return rateType;
    }
    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

}
