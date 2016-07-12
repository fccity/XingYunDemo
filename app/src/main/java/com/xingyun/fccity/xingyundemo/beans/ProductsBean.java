package com.xingyun.fccity.xingyundemo.beans;

import java.io.Serializable;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsBean implements Serializable{
    /**
     * pid
     */
    private String pid;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 备注
     */
    private String memo;
    /**
     * 价格
     */
    private String price;
    /**
     * 单价
     */
    private String unitprice;
    /**
     * 市场价
     */
    private String marketprice;
    /**
     * 图片地址
     */
    private String imgsrc;

    public ProductsBean(String pid, String name, String memo, String price, String unitprice, String marketprice, String imgsrc) {
        this.pid = pid;
        this.name = name;
        this.memo = memo;
        this.price = price;
        this.unitprice = unitprice;
        this.marketprice = marketprice;
        this.imgsrc = imgsrc;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(String marketprice) {
        this.marketprice = marketprice;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
