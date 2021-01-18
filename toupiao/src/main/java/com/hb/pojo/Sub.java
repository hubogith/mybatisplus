package com.hb.pojo;

import java.io.Serializable;

public class Sub implements Serializable {
    //`sub_id``sub_title``sub_type`
    private Integer subId;
    private String subTitle;
    private Integer subType;

    public Sub() {
    }

    public Sub(Integer subId, Integer subType) {
        this.subId = subId;
        this.subType = subType;
    }

    public Sub(Integer subId, String subTitle, Integer subType) {
        this.subId = subId;
        this.subTitle = subTitle;
        this.subType = subType;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    @Override
    public String toString() {
        return "Sub{" +
                "subId=" + subId +
                ", subTitle='" + subTitle + '\'' +
                ", subType=" + subType +
                '}';
    }
}
