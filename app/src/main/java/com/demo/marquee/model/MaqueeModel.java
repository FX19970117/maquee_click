package com.demo.marquee.model;

/**
 * Created by SEELE on 2016/8/26.
 */
public class MaqueeModel {


    /**
     * code : SZ3990011
     * name : 深证成指1
     * price : 10748
     * percent : 10
     */

    private String code;
    private String name;
    private int price;
    private int percent;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
