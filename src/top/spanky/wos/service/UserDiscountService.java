package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.UserDiscount;

public interface UserDiscountService {

    public List getAllUseableDiscountByUserId(int userId);

    public List getAllByUserId(int userId);

    public UserDiscount getById(int id);

    public boolean add(UserDiscount userDiscount);

    public boolean deleteById(int id);

}
