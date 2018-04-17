package top.spanky.wos.model;

import java.util.List;

public class Food {
    @Override
    public String toString() {
        return "Food [id=" + id + ", foodType=" + foodType + ", name=" + name + ", description=" + description
                + ", info=" + info + ", price=" + price + ", oldPrice=" + oldPrice + ", sellCount=" + sellCount
                + ", leftCount=" + leftCount + ", icon=" + icon + ", image=" + image + ", foodRatings=" + foodRatings
                + "]";
    }

    private Integer id;
    private FoodType foodType;
    private String name;
    private String description;
    private String info;
    private Double price;
    private Double oldPrice;
    private Integer sellCount;
    private Integer leftCount;
    private String icon;
    private String image;
    private List<FoodRating> foodRatings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(int index) {
        for (FoodType foodType : FoodType.values()) {
            if (foodType.getIndex() == index) {
                this.foodType = foodType;
                return;
            }
        }
        this.foodType = FoodType.QT;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public Integer getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FoodRating> getFoodRatings() {
        return foodRatings;
    }

    public void setFoodRatings(List<FoodRating> foodRatings) {
        this.foodRatings = foodRatings;
    }

}
