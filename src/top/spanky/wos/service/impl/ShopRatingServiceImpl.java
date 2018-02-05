package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.ShopRatingDao;
import top.spanky.wos.model.ShopRating;
import top.spanky.wos.service.ShopRatingService;

public class ShopRatingServiceImpl implements ShopRatingService {

    private ShopRatingDao shopRatingDao;

    public void setShopRatingDao(ShopRatingDao shopRatingDao) {
        this.shopRatingDao = shopRatingDao;
    }

    @Override
    public List<ShopRating> getAllShopRatings() {
        return shopRatingDao.getAllShopRatings();
    }

    @Override
    public List<ShopRating> getShopRatingsByUserId(int userId) {
        return shopRatingDao.getShopRatingsByUserId(userId);
    }

}
