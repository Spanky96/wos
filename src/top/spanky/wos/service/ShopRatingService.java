package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.ShopRating;

public interface ShopRatingService {

    public List<ShopRating> getAllShopRatings();

    public List<ShopRating> getShopRatingsByUserId(int userId);
}
