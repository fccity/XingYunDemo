package com.xingyun.fccity.xingyundemo.beans;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsDetailsBean {
    /**
     * pid
     */
    private String pid;
    /**
     * 商品名称
     */
    private String name;
    /**
     *  规格
     */
    private String norm;
    /**
     *  等级
     */
    private String grade;
    /**
     * 储存
     */
    private String store;
    /**
     * 性价比
     */
    private String  ppr;
    /**
     * 图片地址
     */
    private String imgsrc;

    public ProductsDetailsBean(String pid, String name, String norm, String grade, String store, String ppr, String imgsrc) {
        this.pid = pid;
        this.name = name;
        this.norm = norm;
        this.grade = grade;
        this.store = store;
        this.ppr = ppr;
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

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPpr() {
        return ppr;
    }

    public void setPpr(String ppr) {
        this.ppr = ppr;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
