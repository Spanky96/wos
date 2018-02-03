package top.spanky.wos.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.spanky.wos.Constants;
import top.spanky.wos.controller.resource.BasicResponse;
import top.spanky.wos.json.MyJsonConfig;
import top.spanky.wos.json.MyJsonService;
import top.spanky.wos.service.FoodService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class TestController extends BaseController {

    private final Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private MyJsonService myJsonService;
    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/load-shopinfo", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject loadShopInfo() {
        JSONObject shopInfo = myJsonService.getShopBasicInfo();
        List foods = foodService.getAllFoods();
        shopInfo.put("foods", JSONArray.fromObject(foods, MyJsonConfig.getMyJsonConfig()));
        return shopInfo;
    }

    @RequestMapping(value = "/update-shopConfig", method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse setBasicShopConfig(@RequestBody JSONObject config) {
        return myJsonService.setBasicInfoJsonFile(config) ? SUCCESS : FAIL;
    }
}
