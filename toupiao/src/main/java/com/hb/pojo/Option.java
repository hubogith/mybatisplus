package com.hb.pojo;

import java.io.Serializable;
import java.util.Set;

public class Option implements Serializable {
    //`option_id``sub_id``option_concat``option_order`
    private Integer optionId;
    private Integer subId;
    private String optionConcat;//选项内容
    private Integer optionOrder;


    private Sub sub;

    public Option() {
    }

    //修改用的
    public Option(Integer optionId, String optionConcat) {
        this.optionId = optionId;
        this.optionConcat = optionConcat;
    }

    public Option(Integer subId, String optionConcat, Integer optionOrder) {
        this.subId = subId;
        this.optionConcat = optionConcat;
        this.optionOrder = optionOrder;
    }

    public Option(Integer optionId, Integer subId, String optionConcat, Integer optionOrder, Sub sub) {
        this.optionId = optionId;
        this.subId = subId;
        this.optionConcat = optionConcat;
        this.optionOrder = optionOrder;
        this.sub = sub;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getOptionConcat() {
        return optionConcat;
    }

    public void setOptionConcat(String optionConcat) {
        this.optionConcat = optionConcat;
    }

    public Integer getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(Integer optionOrder) {
        this.optionOrder = optionOrder;
    }

    public Sub getSub() {
        return sub;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + optionId +
                ", subId=" + subId +
                ", optionConcat='" + optionConcat + '\'' +
                ", optionOrder=" + optionOrder +
                ", sub=" + sub +
                '}';
    }
}
