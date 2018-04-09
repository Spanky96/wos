package top.spanky.wos.controller.pojo;

import top.spanky.wos.model.ShopRating;

public class OrderShopRatingDto {
    private Double score1;
    private Double score2;
    private Integer type;
    private String text;

    public OrderShopRatingDto() {
    }

    public OrderShopRatingDto(ShopRating shopRating) {
        this.score1 = shopRating.getScore1();
        this.score2 = shopRating.getScore2();
        this.type = shopRating.getRateType();
        this.text = shopRating.getText();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
