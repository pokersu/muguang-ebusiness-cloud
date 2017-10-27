package com.muguang.ebusiness.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * 发票
 * @author muguang
 * @date 2017-3-7 21:38
 */
public class Invoice implements Serializable{

    private static final long serialVersionUID = 7444088490886094781L;
    private long id;
    private long orderId;
    private String orderSerialno;
    private short invoicetypeId;
    private int cost;
    private short status;
    private int printTimes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSerialno() {
        return orderSerialno;
    }

    public void setOrderSerialno(String orderSerialno) {
        this.orderSerialno = orderSerialno;
    }

    public short getInvoicetypeId() {
        return invoicetypeId;
    }

    public void setInvoicetypeId(short invoicetypeId) {
        this.invoicetypeId = invoicetypeId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(int printTimes) {
        this.printTimes = printTimes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
