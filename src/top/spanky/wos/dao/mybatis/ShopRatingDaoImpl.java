package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.ShopRatingDao;
import top.spanky.wos.model.ShopRating;

public class ShopRatingDaoImpl extends SqlSessionDaoSupport implements ShopRatingDao {
    private static final String CLASS_NAME = ShopRating.class.getName();
    @Override
    public List<ShopRating> getAllShopRatings() {
        return getSqlSession().selectList(CLASS_NAME + ".getAllShopRatings");
    }

    @Override
    public List<ShopRating> getShopRatingsByUserId(int userId) {
        return getSqlSession().selectList(CLASS_NAME + ".getShopRatingsByUserId", userId);
    }

    @Override
    public ShopRating getByOrderId(int orderId) {
        return getSqlSession().selectOne(CLASS_NAME + ".getByOrderId", orderId);
    }

    @Override
    public boolean add(ShopRating shopRating) {
        return getSqlSession().insert(CLASS_NAME + ".add", shopRating) > 0 ? true : false;
    }

}
