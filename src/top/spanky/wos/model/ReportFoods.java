package top.spanky.wos.model;

import java.sql.Timestamp;

public class ReportFoods {
    private String foodList;
    private Timestamp date;

    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
