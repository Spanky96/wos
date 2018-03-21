package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.UserDiscount;

public interface UserDiscountDao {

    public List getAllByUserId(int userId);

    public UserDiscount getById(int id);

    public boolean add(UserDiscount userDiscount);

    public boolean deleteById(int id);

}
