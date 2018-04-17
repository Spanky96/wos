package top.spanky.wos.controller.pojo;

import java.util.List;

import top.spanky.wos.model.Address;
import top.spanky.wos.model.Discount;
import top.spanky.wos.model.Distributor;

public class UserOrderDTO {
    private int orderId;
    private Address address;
    private int status;
    private Discount discount;
    private double foodPrice;
    private double discountPrice;
    private double deliveryPrice;
    private double finalPrice;
    private String remark;
    private Distributor distributor;
    private List<CartListDTO> cartList;
    private long createTime;
    private OrderShopRatingDto rate;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Discount getDiscount() {
        return discount;
    }
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    public double getFoodPrice() {
        return foodPrice;
    }
    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
    public double getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
    public double getDeliveryPrice() {
        return deliveryPrice;
    }
    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
    public Distributor getDistributor() {
        return distributor;
    }
    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }
    public List<CartListDTO> getCartList() {
        return cartList;
    }
    public void setCartList(List<CartListDTO> cartList) {
        this.cartList = cartList;
    }
    public long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public OrderShopRatingDto getRate() {
        return rate;
    }

    public void setRate(OrderShopRatingDto rate) {
        this.rate = rate;
    }


}
