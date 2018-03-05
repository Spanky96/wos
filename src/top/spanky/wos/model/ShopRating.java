package top.spanky.wos.model;

import java.sql.Timestamp;

public class ShopRating extends DisplayInfo {
    private Integer id;
    private Integer userId;
    private Double score1;
    private Double score2;
    private Integer diliveryTime;
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

    public Double getScore1() {
        return score1;
    }

    public void setScore1(Double score1) {
        this.score1 = score1;
    }
    public Double getScore2() {
        return score2;
    }

    public void setScore2(Double score2) {
        this.score2 = score2;
    }

    public Integer getDiliveryTime() {
        return diliveryTime;
    }

    public void setDiliveryTime(Integer diliveryTime) {
        this.diliveryTime = diliveryTime;
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
    @Override
    public String toString() {
        return "ShopRating [id=" + id + ", userId=" + userId + ", score1=" + score1 + ", score2=" + score2
                + ", diliveryTime=" + diliveryTime + ", text=" + text + ", rateTime=" + rateTime + ", rateType="
                + rateType + "]";
    }

}

