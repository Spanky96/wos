package top.spanky.wos.model;

public enum OrderStatus {

    YFK("已付款", 1), MJYJD("卖家已接单", 2), ZZPS("正在配送", 3), YSD("已送达", 4), YPJ("已评价", 5), SFHP("双方互评", 6), YGB("已关闭", 0);

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
