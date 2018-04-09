package top.spanky.wos.controller.resource;

import java.util.List;

import top.spanky.wos.model.Address;

public class OrderResource {

    private boolean temp;
    private double totalPrice;
    private double deliveryPrice;
    private double finalPrice;
    private List<CartList> cartList;
    private String remark;
    // temp only
    private Address address;
    // vip only
    private int userId;
    private int discountId;
    private double disPrice;
    private int addressId;

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public List<CartList> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartList> cartList) {
        this.cartList = cartList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public double getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(double disPrice) {
        this.disPrice = disPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OrderResource [temp=" + temp + ", totalPrice=" + totalPrice + ", deliveryPrice=" + deliveryPrice
                + ", finalPrice=" + finalPrice + ", cartList=" + cartList + ", remark=" + remark + ", address="
                + address + ", userId=" + userId + ", discountId=" + discountId + ", disPrice=" + disPrice
                + ", addressId=" + addressId + "]";
    }

}
