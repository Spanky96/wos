package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.Discount;

public interface DiscountService {

    public List getAll();

    public Discount getById(int id);

    public boolean add(Discount discount);

    public boolean update(Discount discount);

    public boolean deleteById(int id);
}
