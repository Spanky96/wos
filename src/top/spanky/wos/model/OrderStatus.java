package top.spanky.wos.model;

public enum OrderStatus {

    YFK("已付款", 0), GB("订单被关闭", 1), SJYJD("商家已接单", 2), ZZPS("正在配送", 3), YSD("已送达", 4), DDWC("订单完成", 5), YPJ("已评价", 6);

    private int index;
    private String name;

    private OrderStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
