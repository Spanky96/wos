package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.OrderHistory;

public interface OrderHistoryDao {

    public List getAllByOrderId(int orderId);

    public OrderHistory getById(int id);

    public boolean update(OrderHistory orderHistory);

    public boolean add(OrderHistory orderHistory);
}
