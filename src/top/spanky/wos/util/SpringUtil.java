package top.spanky.wos.util;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.spanky.wos.service.UserDiscountService;

public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
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
    public void TestMath() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDiscountService userDiscountService =  (UserDiscountService)ac.getBean("userDiscountService");

        System.out.println(userDiscountService.doSendDiscount("oh56I1rAcdxTDWD-lo8Apoqgzj3g"));

    }

}