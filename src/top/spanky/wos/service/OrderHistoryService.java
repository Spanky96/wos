package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.OrderHistory;

public interface OrderHistoryService {

    public List getAllByOrderId(int orderId);

    public OrderHistory getById(int id);

    public boolean update(OrderHistory orderHistory);

    public boolean add(OrderHistory orderHistory);
}
