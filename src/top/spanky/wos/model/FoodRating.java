package top.spanky.wos.model;

public class FoodRating extends BasicRating {
    private Integer foodId;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    @Override
    public String toString() {
        return "FoodRating [foodId=" + foodId + ", getId()=" + getId() + ", getUserId()=" + getUserId() + ", getText()="
                + getText() + ", getRateTime()=" + getRateTime() + ", getRateType()=" + getRateType() + ", getAvatar()="
                + getAvatar() + ", getDisplayStr()=" + getDisplayStr() + "]";
    }
}

