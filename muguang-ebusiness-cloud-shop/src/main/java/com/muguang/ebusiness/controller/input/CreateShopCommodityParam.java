package com.muguang.ebusiness.controller.input;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 13:22.
 */
public class CreateShopCommodityParam implements Serializable{
    private static final long serialVersionUID = -4764380090634512532L;
    private CreateCommodityParam commodity;
    private List<CreateInventoryParam> inventories;

    public boolean valid(){
        return commodity.getShopId()!=0 && commodity.getCategoryId()!=0;
    }

    public CreateCommodityParam getCommodity() {
        return commodity;
    }

    public void setCommodity(CreateCommodityParam commodity) {
        this.commodity = commodity;
    }

    public List<CreateInventoryParam> getInventories() {
        return inventories;
    }

    public void setInventories(List<CreateInventoryParam> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
