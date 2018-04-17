package top.spanky.wos.model;

public enum FoodType {

    QT("其他", 100), YYZD("营养粥道", 1), JPCT("精品套餐", 2), XCZS("小吃主食", 3), JXRC("精选热菜", 4), SKLC("爽口凉菜", 5), YMYL("一鸣饮料",
            6), ZPTJ("招牌推荐", 0);

    private int index;
    private String name;

    private FoodType(String name, int index) {
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
