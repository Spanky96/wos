package top.spanky.wos.model;

import java.sql.Timestamp;

public class FoodRating {
    private Integer id;
    private Integer foodId;
    private Integer userId;
    private String text;
    private Timestamp time;
    private Integer type; // 1: 好评 0:差评

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
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

    @Override
    public String toString() {
        return "FoodRating [id=" + id + ", foodId=" + foodId + ", userId=" + userId + ", text=" + text + ", time="
                + time + ", type=" + type + "]";
    }

}

