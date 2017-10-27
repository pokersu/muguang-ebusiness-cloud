package com.muguang.ebusiness.controller.input;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author muguang
 * @date 2017/3/8 14:33.
 */
public class PayRequest implements Serializable{
    private static final long serialVersionUID = -6636602148232207169L;

    private long id;
    private String serialNo;
    private String outSerialNo;
    private int payType;
    private int amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOutSerialNo() {
        return outSerialNo;
    }

    public void setOutSerialNo(String outSerialNo) {
        this.outSerialNo = outSerialNo;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
