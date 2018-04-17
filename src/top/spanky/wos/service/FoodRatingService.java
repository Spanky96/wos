package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.FoodRating;

public interface FoodRatingService {

    public List<FoodRating> getAllFoodRatings();

    public List<FoodRating> getFoodRatingsByFoodId(int foodId);

    public List<FoodRating> getFoodRatingsByUserId(int userId);
}
