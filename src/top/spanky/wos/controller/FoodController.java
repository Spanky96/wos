package top.spanky.wos.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.spanky.wos.Constants;
import top.spanky.wos.model.Food;
import top.spanky.wos.service.FoodService;
import top.spanky.wos.service.UserService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class FoodController {

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
}
