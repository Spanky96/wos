package top.spanky.wos.controller.resource;

import java.util.List;

import top.spanky.wos.controller.pojo.UseableDiscountPO;

public class UseableUserDiscountResource {
    private List<UseableDiscountPO> discounts;

    public List<UseableDiscountPO> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<UseableDiscountPO> discounts) {
        this.discounts = discounts;
    }

}
