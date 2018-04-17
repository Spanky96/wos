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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import top.spanky.wos.Constants;
import top.spanky.wos.controller.resource.BasicResponse;
import top.spanky.wos.controller.resource.CartList;
import top.spanky.wos.controller.resource.OrderRateSource;
import top.spanky.wos.controller.resource.OrderResource;
import top.spanky.wos.exception.ServiceException;
import top.spanky.wos.model.Order;
import top.spanky.wos.model.OrderHistory;
import top.spanky.wos.model.OrderStatus;
import top.spanky.wos.service.OrderHistoryService;
import top.spanky.wos.service.OrderService;
import top.spanky.wos.util.SpringUtil;
import top.spanky.wos.web.socket.WebsocketEndPoint;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class OrderController extends BaseController {

    private final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderHistoryService orderHistoryService;

    @RequestMapping(value = "/order/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getUsersOrder(@PathVariable int userId) {
        ModelMap modelMap = new ModelMap();
        List userOrders = orderService.getAllByUserId(userId);
        modelMap.put("orders", userOrders);
        modelMap.put("result", SUCCESS);
        return modelMap;
    }

    @RequestMapping(value = "/order/all-orders", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getAllOrders() {
        ModelMap modelMap = new ModelMap();
        List orders = orderService.getAll();
        modelMap.put("orderList", orders);
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
            modelMap.put("order", order);
        } catch (ServiceException e) {
            modelMap.put("result", FAIL);
            modelMap.put("exception", e.getMessage());
        }

        return modelMap;
    }

    @RequestMapping(value = "/order-history/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getOrderHistory(@PathVariable int orderId) {
        ModelMap modelMap = new ModelMap();
        List<OrderHistory> list = orderHistoryService.getAllByOrderId(orderId);
        modelMap.put("orderHistory", list);
        return modelMap;
    }

    @RequestMapping(value = "/order/addRate", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doOrderRate(@RequestBody String rateStr) {
        OrderRateSource or = (OrderRateSource) JSONObject.toBean(JSONObject.fromObject(rateStr), OrderRateSource.class);
        ModelMap modelMap = new ModelMap();
        try {
            orderService.addRate(or);
            modelMap.put("result", SUCCESS);
        } catch (ServiceException e) {
            modelMap.put("result", FAIL);
            modelMap.put("exception", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/order/reminder/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse doReminder(@PathVariable int orderId) {
        WebsocketEndPoint websocket = (WebsocketEndPoint) SpringUtil.getBean("websocket");
        websocket.sendBroadMessage(orderId, "WosSeller", "reminder");
        return SUCCESS;
    }

    @RequestMapping(value = "/order/setAchieved/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse setAchieved(@PathVariable int orderId) {
        try {
            orderService.doFinishOrder(orderId);
        } catch (ServiceException e) {
            return FAIL;
        }
        return SUCCESS;
    }

    @RequestMapping(value = "/order/doConfirm/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse doConfirm(@PathVariable int orderId) {
        try {
            orderService.updateStatus(orderId, OrderStatus.SJYJD.getIndex());
        } catch (ServiceException e) {
            logger.error("关闭订单空指针异常，orderId：" + orderId);
            return FAIL;
        }
        return SUCCESS;
    }

    @RequestMapping(value = "/order/close/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse doClose(@PathVariable int orderId) {
        try {
            orderService.updateStatus(orderId, OrderStatus.GB.getIndex());
        } catch (ServiceException e) {
            logger.error("关闭订单空指针异常，orderId：" + orderId);
            return FAIL;
        }
        WebsocketEndPoint websocket = (WebsocketEndPoint) SpringUtil.getBean("websocket");
        websocket.sendBroadMessage(orderId, "WosSeller", "close");
        return SUCCESS;
    }

    @RequestMapping(value = "/order/delete/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse doDelete(@PathVariable int orderId) {
        try {
            orderService.updateStatus(orderId, OrderStatus.YSC.getIndex());
        } catch (ServiceException e) {
            logger.error("删除订单空指针异常，orderId：" + orderId);
            return FAIL;
        }
        return SUCCESS;
    }

    @RequestMapping(value = "/order/arrangeDelivery", method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse arrangeDelivery(@RequestParam(value = "orderId") int orderId,
            @RequestParam(value = "distributorId") int distributorId) {
        try {
            orderService.doArrangeDelivery(orderId, distributorId);
        } catch (ServiceException e) {
            logger.error("订单/派送员 空指针异常，orderId：" + orderId);
            return FAIL;
        }
        System.out.println(orderId + distributorId);
        return SUCCESS;

    }

    @RequestMapping(value = "/order/mockNeworder", method = RequestMethod.GET)
    @ResponseBody
    public String messageTest() {
        orderService.sendNewOrderMessage(1);
        return "message send";
    }
}
