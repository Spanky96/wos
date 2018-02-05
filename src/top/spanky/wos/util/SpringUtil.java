package top.spanky.wos.util;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONObject;
import top.spanky.wos.service.ShopRatingService;

public class SpringUtil implements ApplicationContextAware {

    private static final String Food = null;
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        applicationContext = ac;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanId) {
        ApplicationContext applicationContext = getApplicationContext();
        return applicationContext.getBean(beanId);
    }


    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // FoodService us = (FoodService) ac.getBean("foodService");
        //
        // List allFoods = us.getAllFoods();
        // for (Object object : allFoods) {
        // System.out.println(object);
        // }
        // System.out.println(us.getFoodById(1));
        // System.out.println(us.getFoodById(3));
        ShopRatingService us = (ShopRatingService) ac.getBean("shopRatingService");

        System.out.println(JSONObject.fromObject(us.getAllShopRatings().get(0)));

        System.out.println(JSONObject.fromObject(us.getShopRatingsByUserId(1).get(0)));

    }
}