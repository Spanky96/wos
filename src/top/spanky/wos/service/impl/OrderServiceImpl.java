package top.spanky.wos.service.impl;

import java.util.ArrayList;
import java.util.List;

import top.spanky.wos.Constants;
import top.spanky.wos.controller.pojo.CartListDTO;
import top.spanky.wos.controller.pojo.OrderListDTO;
import top.spanky.wos.controller.pojo.OrderShopRatingDto;
import top.spanky.wos.controller.pojo.UserOrderDTO;
import top.spanky.wos.controller.resource.CartList;
import top.spanky.wos.controller.resource.OrderRateSource;
import top.spanky.wos.controller.resource.OrderResource;
import top.spanky.wos.dao.AddressDao;
import top.spanky.wos.dao.DiscountDao;
import top.spanky.wos.dao.DistributorDao;
import top.spanky.wos.dao.FoodDao;
import top.spanky.wos.dao.OrderDao;
import top.spanky.wos.dao.OrderHistoryDao;
import top.spanky.wos.dao.ShopRatingDao;
import top.spanky.wos.dao.UserDao;
import top.spanky.wos.dao.UserDiscountDao;
import top.spanky.wos.exception.ServiceException;
import top.spanky.wos.json.MyJsonService;
import top.spanky.wos.model.Discount;
import top.spanky.wos.model.Distributor;
import top.spanky.wos.model.Food;
import top.spanky.wos.model.Order;
import top.spanky.wos.model.OrderHistory;
import top.spanky.wos.model.OrderStatus;
import top.spanky.wos.model.ShopRating;
import top.spanky.wos.model.UserDiscount;
import top.spanky.wos.service.OrderService;
import top.spanky.wos.util.CommonUtil;
import top.spanky.wos.web.socket.WebsocketEndPoint;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private UserDao userDao;
    private OrderHistoryDao orderHistoryDao;
    private AddressDao addressDao;
    private FoodDao foodDao;
    private DistributorDao distributorDao;
    private DiscountDao discountDao;
    private UserDiscountDao userDiscountDao;
    private MyJsonService myJsonService;
    private ShopRatingDao shopRatingDao;
    private WebsocketEndPoint websocket;

    public void setWebsocket(WebsocketEndPoint websocket) {
        this.websocket = websocket;
    }

    public void setShopRatingDao(ShopRatingDao shopRatingDao) {
        this.shopRatingDao = shopRatingDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public void setDistributorDao(DistributorDao distributorDao) {
        this.distributorDao = distributorDao;
    }

    public void setDiscountDao(DiscountDao discountDao) {
        this.discountDao = discountDao;
    }

    public void setUserDiscountDao(UserDiscountDao userDiscountDao) {
        this.userDiscountDao = userDiscountDao;
    }

    public void setMyJsonService(MyJsonService myJsonService) {
        this.myJsonService = myJsonService;
    }

    public void setOrderHistoryDao(OrderHistoryDao orderHistoryDao) {
        this.orderHistoryDao = orderHistoryDao;
    }

    @Override
    public List getAll() {
        List<Order> orderList = orderDao.getAll();
        List<OrderListDTO> ol = new ArrayList<>();
        for (Order order : orderList) {
            OrderListDTO ur = new OrderListDTO();
            if (order.getUserId() != null) {
                ur.setUser(userDao.getById(order.getUserId()));
            }
            ur.setRemark(order.getRemark());
            ur.setAddress(addressDao.getById(order.getAddressId()));
            ur.setCartList(toCartList(order.getFoodList()));
            ur.setCreateTime(order.getCreateTime().getTime());
            ur.setDeliveryPrice(order.getDeliveryPrice());
            ur.setFinalPrice(order.getFinalPrice());
            ur.setOrderId(order.getId());
            if (order.getDiscountId() != null) {
                ur.setDiscount(discountDao.getByUserDiscountId(order.getDiscountId()));
                ur.setDiscountPrice(order.getDiscountPrice());
            }
            if (order.getDistributorId() != null) {
                ur.setDistributor(distributorDao.getById(order.getDistributorId()));
            }
            ur.setFoodPrice(order.getFoodPrice());
            ur.setStatus(order.getStatus());
            if (order.getStatus() >= OrderStatus.YPJ.getIndex()) {
                ur.setRate(new OrderShopRatingDto(shopRatingDao.getByOrderId(order.getId())));
            }
            ol.add(ur);
        }
        return ol;
    }

    @Override
    public List getAllByUserId(int id) {
        List<Order> orderList = orderDao.getAllByUserId(id);
        List<UserOrderDTO> userOrders = new ArrayList<>();
        for (Order order : orderList) {
            UserOrderDTO ur = new UserOrderDTO();
            ur.setAddress(addressDao.getById(order.getAddressId()));
            ur.setCartList(toCartList(order.getFoodList()));
            ur.setCreateTime(order.getCreateTime().getTime());
            ur.setDeliveryPrice(order.getDeliveryPrice());
            ur.setFinalPrice(order.getFinalPrice());
            ur.setOrderId(order.getId());
            if (order.getDiscountId() != null) {
                ur.setDiscount(discountDao.getByUserDiscountId(order.getDiscountId()));
                ur.setDiscountPrice(order.getDiscountPrice());
            }
            if (order.getDistributorId() != null) {
                ur.setDistributor(distributorDao.getById(order.getDistributorId()));
            }
            ur.setFoodPrice(order.getFoodPrice());
            ur.setStatus(order.getStatus());
            if (order.getStatus() >= OrderStatus.YPJ.getIndex()) {
                ShopRating rate = shopRatingDao.getByOrderId(order.getId());
                if (rate != null) {
                    ur.setRate(new OrderShopRatingDto(rate));
                }
            }
            userOrders.add(ur);
        }
        return userOrders;
    }

    private List<CartListDTO> toCartList(String listStr) {
        List<CartListDTO> cartList = new ArrayList<>();
        String[] itemsStr = listStr.substring(0, listStr.length() - 1).split("\\^");
        for (String item : itemsStr) {
            CartListDTO dto = new CartListDTO();
            String[] info = item.split("\\#");
            Food food = foodDao.getById(new Integer(info[0]));
            dto.setId(food.getId());
            dto.setName(food.getName());
            dto.setPrice(food.getPrice());
            dto.setNumber(new Integer(info[1]));
            cartList.add(dto);
        }
        return cartList;
    }

    @Override
    public Order getByID(int id) {
        return orderDao.getByID(id);
    }

    @Override
    public boolean add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public boolean updateDistributorInfo(Order order, int id) {
        order.setDistributorId(id);
        return updateStatus(order, Constants.ORDER_DELIVEYING);
    }

    @Override
    public boolean updateStatus(Order order, int id) {
        order.setStatus(id);
        OrderHistory orderHistory = new OrderHistory(order.getId(), id, null);
        orderHistoryDao.add(orderHistory);
        return orderDao.update(order);
    }

    @Override
    public boolean updateStatus(int orderId, int id) throws ServiceException {
        Order order = orderDao.getByID(orderId);
        if (order == null)
            throw new ServiceException(2002);

        return updateStatus(order, id);
    }

    @Override
    public Order add(OrderResource or) throws ServiceException {
        // 1 判断起送价是否合理
        if (or.getTotalPrice() < myJsonService.getShopBasicInfo().getJSONObject("seller").getDouble("minPrice"))
            throw new ServiceException(2002);
        // 2 判断运费是否正确
        if (or.getDeliveryPrice() != myJsonService.getShopBasicInfo().getJSONObject("seller")
                .getDouble("deliveryPrice"))
            throw new ServiceException(2002);
        // 3 判断商品总价是否无误
        List<CartList> cartList = or.getCartList();
        double foodPrice = 0;
        for (CartList item : cartList) {
            Food food = foodDao.getById(item.getId());
            foodPrice += (food.getPrice() * item.getNumber());
        }
        foodPrice = (double) Math.round(foodPrice * 100) / 100;

        if (foodPrice != or.getTotalPrice())
            throw new ServiceException(2000);

        Order order = new Order();
        order.setFoodList(CommonUtil.toCartstr(cartList));
        order.setFoodPrice(or.getTotalPrice());
        order.setDeliveryPrice(or.getDeliveryPrice());
        double finalPrice = 0;
        // 4 有无使用优惠券
        if (!or.isTemp() && (or.getDiscountId() != 0)) {
            UserDiscount userdiscount = userDiscountDao.getById(or.getDiscountId());
            if ((userdiscount == null) || (userdiscount.getUserId() != or.getUserId()) || !userdiscount.validate())
                throw new ServiceException(2001);
            else {
                // 使用了优惠券 判断优惠价钱是否合法
                Discount discount = discountDao.getById(userdiscount.getDiscountId());
                double disPrice = 0;
                switch (discount.getType()) {
                case Constants.DISCOUNT_COMMON:
                    // 通用红包
                    disPrice = discount.getDisPrice();
                    break;
                case Constants.DISCOUNT_CONDITION:
                    // 满减红包
                    if (or.getTotalPrice() < discount.getRestrictPrice())
                        throw new ServiceException(2001);
                    disPrice = discount.getDisPrice();
                    break;
                case Constants.DISCOUNT_TAKEOFF:
                    // 打折红包
                    disPrice = (double) Math.round(or.getTotalPrice() * discount.getDisPrice() * 100) / 100;
                    if (disPrice >= discount.getRestrictPrice()) {
                        disPrice = discount.getRestrictPrice();
                    }
                    break;
                case Constants.DISCOUNT_DELIVERY_FREE:
                    // 免运费
                    disPrice = or.getDeliveryPrice();
                    break;
                case Constants.DISCOUNT_RANDOM:
                    // 随机立减
                    double top = Math.min(or.getDeliveryPrice() + or.getTotalPrice(), discount.getRestrictPrice()); // 封顶优惠
                    disPrice = (double) Math.round((Math.random() * top * 100) + 1) / 100;
                    break;
                default:
                    throw new ServiceException(2001);
                }
                order.setDiscountId(or.getDiscountId());
                if ((discount.getType() != Constants.DISCOUNT_RANDOM) && (disPrice != or.getDisPrice()))
                    throw new ServiceException(2001);
                order.setDiscountPrice(disPrice);
                // 将优惠券标志使用
                userDiscountDao.deleteById(userdiscount.getId());
                or.setDiscountId(userdiscount.getId());
                finalPrice = (order.getFoodPrice() + order.getDeliveryPrice()) - order.getDiscountPrice();
            }
        } else {
            finalPrice = order.getFoodPrice() + order.getDeliveryPrice();
        }
        order.setFinalPrice(finalPrice);
        order.setRemark(or.getRemark());
        // 用户的地址
        if (or.isTemp()) {
            addressDao.add(or.getAddress());
            order.setAddressId(or.getAddress().getId());
        } else {
            order.setUserId(or.getUserId());
            order.setAddressId(or.getAddressId());
        }
        // 增加order、orderHistroy

        if (orderDao.add(order)) {
            orderHistoryDao.add(new OrderHistory(order.getId(), OrderHistory.PAY_SUCCESS, null));
        }

        // 通知商家
        if ((websocket.getSessionList() != null) && (websocket.getSessionList().size() > 0)) {
            sendNewOrderMessage(order.getId());
        }

        return order;
    }

    @Override
    public void sendNewOrderMessage(int orderId) {
        Order order = orderDao.getByID(orderId);
        OrderListDTO ur = new OrderListDTO();
        if (order.getUserId() != null) {
            ur.setUser(userDao.getById(order.getUserId()));
        }
        ur.setRemark(order.getRemark());
        ur.setAddress(addressDao.getById(order.getAddressId()));
        ur.setCartList(toCartList(order.getFoodList()));
        ur.setCreateTime(order.getCreateTime().getTime());
        ur.setDeliveryPrice(order.getDeliveryPrice());
        ur.setFinalPrice(order.getFinalPrice());
        ur.setOrderId(order.getId());
        if (order.getDiscountId() != null) {
            ur.setDiscount(discountDao.getByUserDiscountId(order.getDiscountId()));
            ur.setDiscountPrice(order.getDiscountPrice());
        }
        if (order.getDistributorId() != null) {
            ur.setDistributor(distributorDao.getById(order.getDistributorId()));
        }
        ur.setFoodPrice(order.getFoodPrice());
        ur.setStatus(order.getStatus());
        if (order.getStatus() >= OrderStatus.YPJ.getIndex()) {
            ur.setRate(new OrderShopRatingDto(shopRatingDao.getByOrderId(order.getId())));
        }
        websocket.sendBroadMessage(ur, "WosSeller", "newOrder");
    }

    @Override
    public boolean addRate(OrderRateSource or) throws ServiceException {
        Order order = orderDao.getByID(or.getOrderId());
        if (or.getUserId() != order.getUserId())
            throw new ServiceException(2003);
        // 增加评价信息
        ShopRating rate = new ShopRating();
        rate.setScore1(or.getScore1());
        rate.setScore2(or.getScore2());
        rate.setText(or.getText());
        rate.setRateType(or.getType());
        rate.setDiliveryTime(order.getDeliveryTime());
        rate.setUserId(or.getUserId());
        rate.setOrderId(order.getId());
        shopRatingDao.add(rate);

        // 修改订单状态
        order.setStatus(OrderStatus.YPJ.getIndex());
        orderDao.update(order);

        // 增加订单历史
        OrderHistory oh = new OrderHistory();
        oh.setOrderId(order.getId());
        oh.setType(OrderHistory.RATED);
        orderHistoryDao.add(oh);

        return true;
    }

    @Override
    public void doFinishOrder(int orderId) throws ServiceException {
        Order order = orderDao.getByID(orderId);
        if (order == null)
            throw new ServiceException(2002);
        int deliveryTime = (int) Math.round((System.currentTimeMillis() - order.getCreateTime().getTime()) / 60000.0);
        updateStatus(order, Constants.ORDER_DELIVEYED);
        order.setDeliveryTime(deliveryTime);
        orderDao.update(order);
        updateStatus(order, Constants.ORDER_FINISHED);
    }

    @Override
    public void doArrangeDelivery(int orderId, int distributorId) throws ServiceException {
        Order order = orderDao.getByID(orderId);
        if (order == null)
            throw new ServiceException(2002);
        Distributor distributor = distributorDao.getById(distributorId);
        if (distributor == null)
            throw new ServiceException(2004);

        order.setDistributorId(distributorId);
        order.setStatus(Constants.ORDER_DELIVEYING);
        OrderHistory orderHistory = new OrderHistory(order.getId(), distributorId, distributor.getPhone());
        orderHistoryDao.add(orderHistory);
        orderDao.update(order);

    }

}
