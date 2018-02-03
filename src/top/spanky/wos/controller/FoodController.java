package top.spanky.wos.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.spanky.wos.Constants;
import top.spanky.wos.service.FoodService;
import top.spanky.wos.service.UserService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class FoodController {

    private final Logger logger = Logger.getLogger(FoodController.class);

    @Autowired
    private UserService userService;
    private FoodService foodService;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap testAutho(@RequestParam(value = "code", defaultValue = "") String code) {
        ModelMap modelMap = new ModelMap();

        return modelMap;
    }
}
