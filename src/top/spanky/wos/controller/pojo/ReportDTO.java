package top.spanky.wos.controller.pojo;

import java.util.Arrays;

public class ReportDTO {
    private int id;
    private String name;
    private int[] count;

    public ReportDTO() {
    };

    public ReportDTO(int id, String name, int length) {
        this.id = id;
        this.name = name;
        count = new int[length];
    }

    @Override
    public String toString() {
        return "ReportDTO [id=" + id + ", name=" + name + ", count=" + Arrays.toString(count) + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public void addCount(int num, int index) {
        count[index] += num;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReportDTO other = (ReportDTO) obj;
        if (id != other.id)
            return false;
        return true;
    }


}