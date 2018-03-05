package top.spanky.wos.util;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.spanky.wos.service.AddressService;

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
        AddressService us = (AddressService) ac.getBean("addressService");

        // List<Food> allFoods = us.getAllFoods();
        //
        // FoodResource resource = new FoodResource(allFoods);

        // System.out.println(resource.getFoods());
        // System.out.println(JSONArray.fromObject(resource));

        // System.out.println(us.getFoodById(1));
        // System.out.println(us.getFoodById(3));
        // ShopRatingService us = (ShopRatingService) ac.getBean("shopRatingService");
        //
        // System.out.println(JSONObject.fromObject(us.getAllShopRatings().get(0)));
        //
        // System.out.println(JSONObject.fromObject(us.getShopRatingsByUserId(1).get(0)));

        // List<Address> addressList = us.getAllAddressByUserId(5);
        // System.out.println(JSONArray.fromObject(addressList,
        // MyJsonConfig.getMyJsonConfig()));
        //
        // Address add = addressList.get(0);
        // add.setGender(2);
        // add.setName("xwewe");
        // System.out.println(add.getId());
        // System.out.println(us.add(add));
        // System.out.println(add.getId());


    }
}