package pers.laineyc.blackdream.framework.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LaineyC
 *
 */
public class PageResult<E> implements Serializable {

    private static final long serialVersionUID = 1L;

	private List<E> records = new ArrayList<>();

    private Integer total;

    public PageResult(){

    }

    public PageResult(List<E> result, Integer total) {
        this.records = result;
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<E> getRecords() {
        return records;
    }

    public void setRecords(List<E> records) {
        this.records = records;
    }

}
