package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.DiscountDao;
import top.spanky.wos.model.Discount;

public class DiscountDaoImpl extends SqlSessionDaoSupport implements DiscountDao {

    private static final String CLASS_NAME = Discount.class.getName();

    @Override
    public List getAll() {
        return getSqlSession().selectList(CLASS_NAME + ".getAll");
    }

    @Override
    public Discount getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getByID", id);
    }

    @Override
    public boolean add(Discount discount) {
        return getSqlSession().insert(CLASS_NAME + ".add", discount) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(int id) {
        return getSqlSession().update(CLASS_NAME + ".deleteById", id) > 0 ? true : false;
    }

    @Override
    public boolean update(Discount discount) {
        return getSqlSession().update(CLASS_NAME + ".update", discount) > 0 ? true : false;
    }

}
