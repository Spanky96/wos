package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.FoodRatingDao;
import top.spanky.wos.model.FoodRating;

public class FoodRatingDaoImpl extends SqlSessionDaoSupport implements FoodRatingDao {

    private static final String CLASS_NAME = FoodRating.class.getName();

    @Override
    public List<FoodRating> getFoodRatingsByFoodId(int foodId) {
        return getSqlSession().selectList(CLASS_NAME + ".getFoodRatingsByFoodId", foodId);
    }

    @Override
    public List<FoodRating> getFoodRatingsByUserId(int userId) {
        return getSqlSession().selectList(CLASS_NAME + ".getFoodRatingsByUserId", userId);
    }

    @Override
    public List<FoodRating> getAll() {
        return getSqlSession().selectList(CLASS_NAME + ".getAll");
    }

}
