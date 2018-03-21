package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.UserDiscountDao;
import top.spanky.wos.model.UserDiscount;

public class UserDiscountDaoImpl extends SqlSessionDaoSupport implements UserDiscountDao {

    private static final String CLASS_NAME = UserDiscount.class.getName();

    @Override
    public List getAllByUserId(int userId) {
        return getSqlSession().selectList(CLASS_NAME + ".getAllByUserId", userId);
    }

    @Override
    public UserDiscount getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getByID", id);
    }

    @Override
    public boolean add(UserDiscount userDiscount) {
        return getSqlSession().insert(CLASS_NAME + ".add", userDiscount) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(int id) {
        return getSqlSession().update(CLASS_NAME + ".deleteById", id) > 0 ? true : false;
    }

}
