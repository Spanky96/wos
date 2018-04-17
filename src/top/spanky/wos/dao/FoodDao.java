package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.Food;

public interface FoodDao {
    public Food getById(int id);

    public List getAll();

    public boolean add(Food food);

    public boolean edit(Food food);
}
