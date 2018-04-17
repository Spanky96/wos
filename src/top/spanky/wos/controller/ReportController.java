package top.spanky.wos.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.spanky.wos.Constants;
import top.spanky.wos.controller.pojo.ReportFoodsDTO;
import top.spanky.wos.service.ReportService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class ReportController extends BaseController {

    private final Logger logger = Logger.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/report/seller", method = RequestMethod.GET)
    @ResponseBody
    public List getSellerReport() {
        return reportService.getSellerReport();
    }

    @RequestMapping(value = "/report/food", method = RequestMethod.GET)
    @ResponseBody
    public ReportFoodsDTO getFoodsReport() {
        return reportService.getFoodsReport();
    }
}
