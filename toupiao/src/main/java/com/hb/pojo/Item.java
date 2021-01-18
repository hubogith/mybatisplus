package com.hb.pojo;

import java.io.Serializable;

public class Item implements Serializable {
    private Integer itemId;
    private Integer userId;
    private Integer subId;
    private Integer optionId;
    private Integer xuan;//总选项数
    private Integer total;//总票数
    private Integer num;//票数

    private User user;
    private Sub sub;
    private Option option;

    public Item() {
    }

    public Item(Integer userId, Integer subId, Integer optionId) {
        this.userId = userId;
        this.subId = subId;
        this.optionId = optionId;
    }

    public Item(Integer itemId, Integer userId, Integer subId, Integer optionId, Integer xuan, Integer total, Integer num, User user, Sub sub, Option option) {
        this.itemId = itemId;
        this.userId = userId;
        this.subId = subId;
        this.optionId = optionId;
        this.xuan = xuan;
        this.total = total;
        this.num = num;
        this.user = user;
        this.sub = sub;
        this.option = option;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getXuan() {
        return xuan;
    }

    public void setXuan(Integer xuan) {
        this.xuan = xuan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sub getSub() {
        return sub;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", userId=" + userId +
                ", subId=" + subId +
                ", optionId=" + optionId +
                ", xuan=" + xuan +
                ", total=" + total +
                ", user=" + user +
                ", sub=" + sub +
                ", option=" + option +
                '}';
    }
}
