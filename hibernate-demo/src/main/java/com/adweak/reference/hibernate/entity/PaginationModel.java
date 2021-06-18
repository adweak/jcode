package com.adweak.reference.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : xuzhaole
 * @date : 2021/6/17
 */

public class PaginationModel<E> {
    private List<E> rows = new ArrayList();
    private int total;
    private int start;
    private int limit;

    public PaginationModel() {
    }

    public PaginationModel(Collection<? extends E> content, int total, int start, int limit) {
        this.rows.addAll(content);
        this.total = total;
        this.start = start;
        this.limit = limit;
    }

    public PaginationModel(Collection<? extends E> content, int start, int limit) {
        this.rows.addAll(content);
        this.start = start;
        this.limit = limit;
    }

    public List<E> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public int getStart() {
        return this.start;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String toString() {
        return "PaginationModel [rows=" + this.rows + ", total=" + this.total + ", start=" + this.start + ", limit=" + this.limit + "]";
    }
}
