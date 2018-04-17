package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.FoodDao;
import top.spanky.wos.model.Food;

public class FoodDaoImpl extends SqlSessionDaoSupport implements FoodDao {

    private static final String CLASS_NAME = Food.class.getName();
    private static final String SQL_ID_FOOD_GET_FOOD_BY_ID = ".getById";
    private static final String SQL_ID_FOOD_GET_ALL_FOOD = ".getAll";

    @Override
    public Food getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_FOOD_GET_FOOD_BY_ID, id);
    }

    @Override
    public List getAll() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FOOD_GET_ALL_FOOD);
    }

    @Override
    public boolean add(Food food) {
        return getSqlSession().insert(CLASS_NAME + ".add", food) > 0 ? true : false;
    }

    @Override
    public boolean edit(Food food) {
        return getSqlSession().update(CLASS_NAME + ".update", food) > 0 ? true : false;
    }

}
