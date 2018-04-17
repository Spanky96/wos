package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.controller.pojo.ReportFoodsDTO;

public interface ReportService {

    public List getSellerReport();

    public ReportFoodsDTO getFoodsReport();
}
