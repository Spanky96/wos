package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.FoodRatingDao;
import top.spanky.wos.model.FoodRating;
import top.spanky.wos.service.FoodRatingService;

public class FoodRatingServiceImpl implements FoodRatingService {

    private FoodRatingDao foodRatingDao;

    public void setFoodRatingDao(FoodRatingDao foodRatingDao) {
        this.foodRatingDao = foodRatingDao;
    }

    @Override
    public List<FoodRating> getFoodRatingsByFoodId(int foodId) {
        return foodRatingDao.getFoodRatingsByFoodId(foodId);
    }

    @Override
    public List<FoodRating> getFoodRatingsByUserId(int userId) {
        return foodRatingDao.getFoodRatingsByUserId(userId);
    }

}
