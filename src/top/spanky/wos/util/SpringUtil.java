package top.spanky.wos.util;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONObject;
import top.spanky.wos.controller.resource.OrderResource;
import top.spanky.wos.service.DiscountService;
import top.spanky.wos.service.DistributorService;
import top.spanky.wos.service.OrderService;
import top.spanky.wos.service.UserDiscountService;

public class SpringUtil implements ApplicationContextAware {

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
    public void discountTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DiscountService ds = (DiscountService)ac.getBean("discountService");
    }

    @Test
    public void distributorTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DistributorService ds = (DistributorService) ac.getBean("distributorService");
    }

    @Test
    public void userDiscountTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDiscountService ds = (UserDiscountService) ac.getBean("userDiscountService");
    }

    @Test
    public void OrderTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService ds = (OrderService) ac.getBean("orderService");
    }

    @Test
    public void TestOrderSource1() {
        String resource = "{\n" + "    \"temp\": true,\n" + "    \"totalPrice\": 1.12,\n"
                + "    \"deliveryPrice\": 0.04,\n" + "    \"finalPrice\": 1.16,\n" + "    \"cartList\": [\n"
                + "            {\"id\": 1, \"number\": 4},\n" + "            {\"id\": 2, \"number\": 1}\n"
                + "        ],\n" + "    \"address\": {\n" + "                \"name\": \"仰一鸣\",\n"
                + "                \"gender\": 1,\n" + "                \"phone\": \"18795950631\",\n"
                + "                \"address\": \"大河\"\n" + "    }\n" + "    \n" + "}";
        JSONObject job = JSONObject.fromObject(resource);
        OrderResource bean = (OrderResource) JSONObject.toBean(job, OrderResource.class);
        System.out.println(bean);

    }

    @Test
    public void TestOrderSource2() {
        String resource = "{\n" + "    \"temp\": false,\n" + "    \"userId\": 1,\n" + "    \"discountId\": 1,\n"
                + "    \"disPrice\": 0.00, \n" + "    \"totalPrice\": 1.12,\n" + "    \"deliveryPrice\": 0.04,\n"
                + "    \"finalPrice\": 1.16,\n" + "    \"cartList\": [\n" + "            {\"id\": 1, \"number\": 4},\n"
                + "            {\"id\": 2, \"number\": 1}\n" + "        ]\n" + "}";
        JSONObject job = JSONObject.fromObject(resource);
        OrderResource bean = (OrderResource) JSONObject.toBean(job, OrderResource.class);
        System.out.println(bean);

    }

    @Test
    public void TestMath() {
        System.out.println(Math.round((Math.random() * 45) + 1) / 100.0); // [0,1)

    }
}