package dto;

import entity.BaseEntity;

import java.util.List;

public class EntityTotal<E extends BaseEntity> {
    private int total;
    private List<E> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
