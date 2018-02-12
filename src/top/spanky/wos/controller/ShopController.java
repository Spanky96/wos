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
import top.spanky.wos.controller.resource.FoodResource;
import top.spanky.wos.json.MyJsonConfig;
import top.spanky.wos.json.MyJsonService;
import top.spanky.wos.model.Food;
import top.spanky.wos.model.ShopRating;
import top.spanky.wos.service.FoodService;
import top.spanky.wos.service.ShopRatingService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class ShopController extends BaseController {

    private final Logger logger = Logger.getLogger(ShopController.class);

    @Autowired
    private MyJsonService myJsonService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private ShopRatingService shopRatingService;

    @RequestMapping(value = "/load-shopinfo", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject loadShopInfo() {
        JSONObject shopInfo = myJsonService.getShopBasicInfo();
        return shopInfo;
    }

    @RequestMapping(value = "/load-foodinfo", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject loadFoodsInfo() {
        List<Food> foods = foodService.getAllFoods();
        return JSONObject.fromObject(new FoodResource(foods));
    }

    @RequestMapping(value = "/update-shopConfig", method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse setBasicShopConfig(@RequestBody JSONObject config) {
        return myJsonService.setBasicInfoJsonFile(config) ? SUCCESS : FAIL;
    }

    @RequestMapping(value = "/all-shopratings", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllShopRatings() {
        List<ShopRating> shopRatings = shopRatingService.getAllShopRatings();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ratings", JSONArray.fromObject(shopRatings, MyJsonConfig.getMyJsonConfig()));
        return jsonObject;
    }
}
