package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.FoodDao;
import top.spanky.wos.model.Food;
import top.spanky.wos.service.FoodService;

public class FoodServiceImpl implements FoodService {

    private FoodDao foodDao;

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public Food getFoodById(int id) {
        return foodDao.getById(id);
    }

    @Override
    public List getAllFoods() {
        return foodDao.getAll();
    }

}
