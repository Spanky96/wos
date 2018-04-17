package top.spanky.wos.controller.pojo;

import java.util.HashSet;
import java.util.Set;

public class ReportFoodsDTO {

    private Set<String> date;

    private Set<ReportDTO> data;

    public Set<String> getDate() {
        if (date == null) {
            date = new HashSet<>();
        }
        return date;
    }

    public void setDate(Set<String> date) {
        this.date = date;
    }

    public Set<ReportDTO> getData() {
        if (data == null) {
            data = new HashSet<>();
        }
        return data;
    }

    public void setData(Set<ReportDTO> data) {
        this.data = data;
    }

}
