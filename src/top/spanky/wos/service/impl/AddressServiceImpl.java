package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.AddressDao;
import top.spanky.wos.model.Address;
import top.spanky.wos.service.AddressService;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List getAllAddressByUserId(int userId) {
        return addressDao.getAllAddressByUserId(userId);
    }

    @Override
    public boolean update(Address newAddress) {
        return addressDao.update(newAddress);
    }

    @Override
    public boolean add(Address newAddress) {
        return addressDao.add(newAddress);
    }

    @Override
    public boolean deleteById(int id) {
        return addressDao.deleteById(id);
    }

}
