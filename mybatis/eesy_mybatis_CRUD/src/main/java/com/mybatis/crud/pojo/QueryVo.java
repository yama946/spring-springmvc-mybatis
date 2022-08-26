package com.mybatis.crud.pojo;

import java.util.List;

public class QueryVo {
    private User u;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public QueryVo(User u) {
        this.u = u;
    }

    public QueryVo() {
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "u=" + u +
                '}';
    }
}
