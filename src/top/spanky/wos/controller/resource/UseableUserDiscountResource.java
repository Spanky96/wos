package top.spanky.wos.controller.resource;

import java.util.List;

import top.spanky.wos.controller.pojo.UseableDiscountDTO;

public class UseableUserDiscountResource {
    private List<UseableDiscountDTO> discounts;

    public List<UseableDiscountDTO> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<UseableDiscountDTO> discounts) {
        this.discounts = discounts;
    }

}
