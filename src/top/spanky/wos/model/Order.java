package top.spanky.wos.model;

import java.sql.Timestamp;

public class Order {
    private Integer id;
    private Integer userId;
    private String foodList;
    private Integer addressId;
    private String remark;
    private Integer status;
    private Double foodPrice;
    private Double deliveryPrice;
    private Double discountPrice;
    private Double finalPrice;
    private Integer discountId;
    private Integer distributorId;
    private Integer diliveryTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public Integer getDiliveryTime() {
        return diliveryTime;
    }

    public void setDisliveryTime(Integer diliveryTime) {
        this.diliveryTime = diliveryTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", userId=" + userId + ", foodList=" + foodList + ", addressId=" + addressId
                + ", remark=" + remark + ", status=" + status + ", foodPrice=" + foodPrice + ", deliveryPrice="
                + deliveryPrice + ", discountPrice=" + discountPrice + ", finalPrice=" + finalPrice + ", discountId="
                + discountId + ", distributorId=" + distributorId + ", createTime=" + createTime + ", updateTime="
                + updateTime + "]";
    }

}
