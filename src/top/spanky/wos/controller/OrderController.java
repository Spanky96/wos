package top.spanky.wos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import top.spanky.wos.Constants;
import top.spanky.wos.controller.resource.CartList;
import top.spanky.wos.controller.resource.OrderResource;
import top.spanky.wos.exception.ServiceException;
import top.spanky.wos.model.Order;
import top.spanky.wos.service.OrderService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class OrderController extends BaseController {

    private final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getUsersOrder(@PathVariable int userId) {
        ModelMap modelMap = new ModelMap();
        List userOrders = orderService.getAllByUserId(userId);
        modelMap.put("orders", userOrders);
        modelMap.put("result", SUCCESS);
        return modelMap;
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap add(@RequestBody String orderStr) {
        Map<String, Object> classMap = new HashMap<String, Object>();
        classMap.put("cartList", CartList.class);
        OrderResource or = (OrderResource) JSONObject.toBean(JSONObject.fromObject(orderStr), OrderResource.class,
                classMap);
        ModelMap modelMap = new ModelMap();
        try {
            Order order = orderService.add(or);
            modelMap.put("result", SUCCESS);
            modelMap.put("orderId", order.getId());
        } catch (ServiceException e) {
            modelMap.put("result", FAIL);
            modelMap.put("exception", e.getMessage());
        }

        return modelMap;
    }
}
