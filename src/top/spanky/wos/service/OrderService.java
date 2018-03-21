package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.controller.resource.OrderResource;
import top.spanky.wos.exception.ServiceException;
import top.spanky.wos.model.Order;

public interface OrderService {

    public List getAll();

    public List getAllByUserId(int id);

    public Order getByID(int id);

    public boolean add(Order order);

    public Order add(OrderResource or) throws ServiceException;

    public boolean updateDistributorInfo(Order order, int id);

    public boolean updateStatus(Order order, int id);

}
