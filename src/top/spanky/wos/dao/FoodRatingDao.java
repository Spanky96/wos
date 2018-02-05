package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.FoodRating;

public interface FoodRatingDao {

    public List<FoodRating> getFoodRatingsByFoodId(int foodId);

    public List<FoodRating> getFoodRatingsByUserId(int userId);
}
