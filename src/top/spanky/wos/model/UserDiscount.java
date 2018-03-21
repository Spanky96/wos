package top.spanky.wos.model;

import java.sql.Timestamp;

public class UserDiscount {

    private Integer id;
    private Integer userId;
    private Integer discountId;
    private Timestamp timeStart;
    private Timestamp timeOver;
    private boolean isUsed;

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

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeOver() {
        return timeOver;
    }

    public void setTimeOver(Timestamp timeOver) {
        this.timeOver = timeOver;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    @Override
    public String toString() {
        return "UserDiscount [id=" + id + ", userId=" + userId + ", discountId=" + discountId + ", timeStart="
                + timeStart + ", timeOver=" + timeOver + ", isUsed=" + isUsed + "]";
    }

    public boolean validate() {
        if (this.isUsed)
            return false;
        long now = System.currentTimeMillis();
        if ((now <= timeOver.getTime()) && (now >= timeStart.getTime()))
            return true;
        return false;
    }

}
