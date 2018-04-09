package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.ShopRating;

public interface ShopRatingDao {

    public List<ShopRating> getAllShopRatings();

    public List<ShopRating> getShopRatingsByUserId(int userId);

    public ShopRating getByOrderId(int orderId);

    public boolean add(ShopRating shopRating);
}
