package top.spanky.wos.model;

public class Discount {

    private Integer id;
    private String name;
    private String description;
    private Double disPrice;
    private Double restrictPrice;
    /*
     * 0 描述数据，一般不查询。 1 通用红包 2 满减红包 3 打折红包 4 免配送费红包 5 随机立减红包
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(Double disPrice) {
        this.disPrice = disPrice;
    }

    public Double getRestrictPrice() {
        return restrictPrice;
    }

    public void setRestrictPrice(Double restrictPrice) {
        this.restrictPrice = restrictPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Discount [id=" + id + ", name=" + name + ", description=" + description + ", disPrice=" + disPrice
                + ", restrictPrice=" + restrictPrice + ", type=" + type + "]";
    }

}
