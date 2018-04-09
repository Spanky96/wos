package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.Order;

public interface OrderDao {

    public List getAll();

    public List getAllByUserId(int id);

    public Order getByID(int id);

    public boolean add(Order order);

    public boolean update(Order order);

}
