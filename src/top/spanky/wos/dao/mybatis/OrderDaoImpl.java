package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.OrderDao;
import top.spanky.wos.model.Order;

public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao {

    private static final String CLASS_NAME = Order.class.getName();

    @Override
    public List getAll() {
        return getSqlSession().selectList(CLASS_NAME + ".getAll");
    }

    @Override
    public List getAllByUserId(int id) {
        return getSqlSession().selectList(CLASS_NAME + ".getAllByUserId", id);
    }

    @Override
    public Order getByID(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getByID", id);
    }

    @Override
    public boolean add(Order order) {
        return getSqlSession().insert(CLASS_NAME + ".add", order) > 0 ? true : false;
    }

    @Override
    public boolean update(Order order) {
        return getSqlSession().update(CLASS_NAME + ".update", order) > 0 ? true : false;
    }

}
