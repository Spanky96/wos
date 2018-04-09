package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.OrderHistoryDao;
import top.spanky.wos.model.OrderHistory;

public class OrderHistoryDaoImpl extends SqlSessionDaoSupport implements OrderHistoryDao {

    private static final String CLASS_NAME = OrderHistory.class.getName();

    @Override
    public List getAllByOrderId(int orderId) {
        return getSqlSession().selectList(CLASS_NAME + ".getAllByOrderId", orderId);
    }

    @Override
    public OrderHistory getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getByID", id);
    }

    @Override
    public boolean update(OrderHistory orderHistory) {
        return getSqlSession().insert(CLASS_NAME + ".update", orderHistory) > 0 ? true : false;
    }

    @Override
    public boolean add(OrderHistory orderHistory) {
        return getSqlSession().insert(CLASS_NAME + ".add", orderHistory) > 0 ? true : false;
    }

}
