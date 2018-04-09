package top.spanky.wos.service.impl;

import java.util.ArrayList;
import java.util.List;

import top.spanky.wos.controller.pojo.UseableDiscountDTO;
import top.spanky.wos.controller.pojo.UserDiscountDTO;
import top.spanky.wos.dao.DiscountDao;
import top.spanky.wos.dao.UserDiscountDao;
import top.spanky.wos.model.UserDiscount;
import top.spanky.wos.service.UserDiscountService;

public class UserDiscountServiceImpl implements UserDiscountService {

    private UserDiscountDao userDiscountDao;
    private DiscountDao discountDao;

    public void setUserDiscountDao(UserDiscountDao userDiscountDao) {
        this.userDiscountDao = userDiscountDao;
    }

    public void setDiscountDao(DiscountDao discountDao) {
        this.discountDao = discountDao;
    }

    @Override
    public List getAllByUserId(int userId) {
        List<UserDiscount> discountList = userDiscountDao.getAllByUserId(userId);
        List<UserDiscountDTO> resultList = new ArrayList<>();
        for (UserDiscount discount : discountList) {
            resultList.add(new UserDiscountDTO(discountDao.getById(discount.getDiscountId()), discount));
        }
        return resultList;
    }

    @Override
    public UserDiscount getById(int id) {
        return userDiscountDao.getById(id);
    }

    @Override
    public boolean add(UserDiscount userDiscount) {
        return userDiscountDao.add(userDiscount);
    }

    @Override
    public boolean deleteById(int id) {
        return userDiscountDao.deleteById(id);
    }

    @Override
    public List getAllUseableDiscountByUserId(int userId) {
        List<UserDiscount> discountList = userDiscountDao.getAllByUserId(userId);
        List<UseableDiscountDTO> resultList = new ArrayList<>();
        for (UserDiscount discount : discountList) {
            if (discount.validate()) {
                resultList.add(new UseableDiscountDTO(discountDao.getById(discount.getDiscountId()), discount.getId()));
            }
        }
        return resultList;
    }

}
