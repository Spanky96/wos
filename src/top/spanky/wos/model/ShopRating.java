package top.spanky.wos.model;

public class ShopRating extends BasicRating {
    private Double score1;
    private Double score2;
    private Integer diliveryTime;
    private Integer orderId;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}

