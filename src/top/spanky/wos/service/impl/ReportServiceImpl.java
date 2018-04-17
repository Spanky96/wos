package top.spanky.wos.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import top.spanky.wos.controller.pojo.CartListDTO;
import top.spanky.wos.controller.pojo.ReportDTO;
import top.spanky.wos.controller.pojo.ReportFoodsDTO;
import top.spanky.wos.dao.FoodDao;
import top.spanky.wos.dao.mybatis.ReportFoodDaoImpl;
import top.spanky.wos.dao.mybatis.ReportSellerDaoImpl;
import top.spanky.wos.model.Food;
import top.spanky.wos.model.ReportFoods;
import top.spanky.wos.service.ReportService;

public class ReportServiceImpl implements ReportService {

    private static final String Set = null;
    private ReportSellerDaoImpl reportSellerDao;
    private ReportFoodDaoImpl reportFoodDao;
    private FoodDao foodDao;

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public void setReportSellerDao(ReportSellerDaoImpl reportSellerDao) {
        this.reportSellerDao = reportSellerDao;
    }

    public void setReportFoodDao(ReportFoodDaoImpl reportFoodDao) {
        this.reportFoodDao = reportFoodDao;
    }

    @Override
    public List getSellerReport() {
        return reportSellerDao.getAll();
    }

    @Override
    public ReportFoodsDTO getFoodsReport() {
        ReportFoodsDTO dto = new ReportFoodsDTO();
        List<ReportFoods> reportFoodDaoList = reportFoodDao.getAll();
        HashSet<String> dateSet = new HashSet<>();
        for (ReportFoods rf : reportFoodDaoList) {
            dateSet.add(new Date(rf.getDate().getTime()).toString());
        }
        dto.setDate(dateSet);
        int length = dateSet.size();
        HashSet<ReportDTO> data = new HashSet<>();
        HashSet<String> tempDateSet = new HashSet<>();
        for (ReportFoods rf : reportFoodDaoList) {
            tempDateSet.add(new Date(rf.getDate().getTime()).toString());
            List<CartListDTO> cartList = toCartList(rf.getFoodList());
            for (CartListDTO cartListDTO : cartList) {
                data.add(new ReportDTO(cartListDTO.getId(), cartListDTO.getName(), length));
                for (ReportDTO rd : data) {
                    if (rd.getId() == cartListDTO.getId()) {
                        rd.addCount(cartListDTO.getNumber(), tempDateSet.size() - 1);
                        break;
                    }
                }
            }
        }
        dto.setData(data);

        return dto;
    }

    private List<CartListDTO> toCartList(String listStr) {
        List<CartListDTO> cartList = new ArrayList<>();
        String[] itemsStr = listStr.substring(0, listStr.length() - 1).split("\\^");
        for (String item : itemsStr) {
            CartListDTO dto = new CartListDTO();
            String[] info = item.split("\\#");
            Food food = foodDao.getById(new Integer(info[0]));
            dto.setId(food.getId());
            dto.setName(food.getName());
            dto.setNumber(new Integer(info[1]));
            cartList.add(dto);
        }
        return cartList;
    }


}
