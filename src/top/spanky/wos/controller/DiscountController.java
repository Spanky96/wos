package top.spanky.wos.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.spanky.wos.Constants;
import top.spanky.wos.service.DiscountService;
import top.spanky.wos.service.UserDiscountService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class DiscountController extends BaseController {

    private final Logger logger = Logger.getLogger(DiscountController.class);

    @Autowired
    private UserDiscountService userDiscountService;
    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "/user-discounts/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getAllUserDiscount(@PathVariable int userId) {
        ModelMap map = new ModelMap();
        List discounts = userDiscountService.getAllUseableDiscountByUserId(userId);
        map.put("discounts", discounts);
        return map;
    }

}
