package top.spanky.wos.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import top.spanky.wos.Constants;
import top.spanky.wos.controller.pojo.UseableDiscountDTO;
import top.spanky.wos.controller.pojo.UserDiscountDTO;
import top.spanky.wos.dao.DiscountDao;
import top.spanky.wos.dao.UserDao;
import top.spanky.wos.dao.UserDiscountDao;
import top.spanky.wos.model.Discount;
import top.spanky.wos.model.User;
import top.spanky.wos.model.UserDiscount;
import top.spanky.wos.service.UserDiscountService;
import top.spanky.wos.util.CommonUtil;

public class UserDiscountServiceImpl implements UserDiscountService {

    private UserDiscountDao userDiscountDao;
    private DiscountDao discountDao;
    private UserDao userDao;

    public void setUserDiscountDao(UserDiscountDao userDiscountDao) {
        this.userDiscountDao = userDiscountDao;
    }

    public void setDiscountDao(DiscountDao discountDao) {
        this.discountDao = discountDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
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

    @Override
    public String doSendDiscount(String openId) {
        User user = userDao.getByOpenID(openId);
        if (user == null)
            return Constants.DISCOUNT_MESSAGE_FAIL;
        if (userDiscountDao.getTodayDiscountByUserId(user.getId()) == 0) {
            // 今日未领取 送红包
            UserDiscount ud = new UserDiscount();
            ud.setUserId(user.getId());
            List all = discountDao.getAll();
            int index = (int) (Math.random() * all.size());
            int discountId = ((Discount) all.get(index)).getId();
            ud.setDiscountId(discountId);
            ud.setTimeStart(new Timestamp(System.currentTimeMillis()));
            ud.setTimeOver(new Timestamp(CommonUtil.getTodaysLastSecond()));
            userDiscountDao.add(ud);
            return Constants.DISCOUNT_MESSAGE_SUCCESS;
        } else
            return Constants.DISCOUNT_MESSAGE_FAIL2;
    }

}
