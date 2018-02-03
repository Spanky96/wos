package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.Food;

public interface FoodService {

    public Food getFoodById(int id);

    public List getAllFoods();
}
