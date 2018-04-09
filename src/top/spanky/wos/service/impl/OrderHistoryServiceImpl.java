package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.OrderHistoryDao;
import top.spanky.wos.model.OrderHistory;
import top.spanky.wos.service.OrderHistoryService;

public class OrderHistoryServiceImpl implements OrderHistoryService {

    private OrderHistoryDao orderHistoryDao;

    public void setOrderHistoryDao(OrderHistoryDao orderHistoryDao) {
        this.orderHistoryDao = orderHistoryDao;
    }

    @Override
    public List getAllByOrderId(int orderId) {
        return orderHistoryDao.getAllByOrderId(orderId);
    }

    @Override
    public OrderHistory getById(int id) {
        return orderHistoryDao.getById(id);
    }

    @Override
    public boolean update(OrderHistory orderHistory) {
        return orderHistoryDao.update(orderHistory);
    }

    @Override
    public boolean add(OrderHistory orderHistory) {
        return orderHistoryDao.add(orderHistory);
    }


}
