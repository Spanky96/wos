package top.spanky.wos.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.spanky.wos.Constants;
import top.spanky.wos.controller.resource.BasicResponse;
import top.spanky.wos.json.MyJsonConfig;
import top.spanky.wos.model.Food;
import top.spanky.wos.service.FoodService;
import top.spanky.wos.service.UserService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class FoodController extends BaseController {

    private final Logger logger = Logger.getLogger(FoodController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/food/{foodId}", method = RequestMethod.GET)
    @ResponseBody
    public Food get(@PathVariable int foodId) {
        Food food = foodService.getFoodById(foodId);
        return food;
    }

    @RequestMapping(value = "/food/all-foods", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getAllFoods() {
        return JSONArray.fromObject(foodService.getAllFoods(), MyJsonConfig.getMyJsonConfig());
    }

    @RequestMapping(value = "/food/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addFood(@RequestBody String foodStr) {
        JSONObject jOb = JSONObject.fromObject(foodStr);
        Food food = (Food) JSONObject.toBean(jOb, Food.class);
        food.setFoodType(new Integer(jOb.getString("foodType")));
        if (foodService.addFood(food))
            return JSONObject.fromObject(food, MyJsonConfig.getMyJsonConfig());
        else
            return null;
    }

    @RequestMapping(value = "/food/edit", method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse editFood(@RequestBody String foodStr) {
        JSONObject jOb = JSONObject.fromObject(foodStr);
        Food food = (Food) JSONObject.toBean(jOb, Food.class);
        food.setFoodType(new Integer(jOb.getString("foodType")));
        if (foodService.editFood(food))
            return SUCCESS;
        else
            return FAIL;
    }
}
