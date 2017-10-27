package com.muguang.ebusiness.controller.input;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author muguang
 * @date 2017/3/8 13:26.
 */
public class CreateInventoryParam implements Serializable{
    private static final long serialVersionUID = 8173735066023861353L;

    private long id;
    private long shopCommodityId;
    private long goodsId;
    private String specifications;
    private int price;
    private int weight;
    private int amount;
    private int status;
    private String code;

    public boolean valid(){
        return true;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getShopCommodityId() {
        return shopCommodityId;
    }

    public void setShopCommodityId(long shopCommodityId) {
        this.shopCommodityId = shopCommodityId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
