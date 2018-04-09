package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.DiscountDao;
import top.spanky.wos.model.Discount;
import top.spanky.wos.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {

    private DiscountDao discountDao;

    public void setDiscountDao(DiscountDao discountDao) {
        this.discountDao = discountDao;
    }

    @Override
    public List getAll() {
        return discountDao.getAll();
    }

    @Override
    public Discount getById(int id) {
        return discountDao.getById(id);
    }

    @Override
    public boolean add(Discount discount) {
        return discountDao.add(discount);
    }

    @Override
    public boolean update(Discount discount) {
        return discountDao.update(discount);
    }

    @Override
    public boolean deleteById(int id) {
        return discountDao.deleteById(id);
    }

}
