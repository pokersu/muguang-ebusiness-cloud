package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.controller.input.CreateCommodityParam;
import com.muguang.ebusiness.controller.input.CreateInventoryParam;
import com.muguang.ebusiness.controller.input.CreateShopCommodityParam;
import com.muguang.ebusiness.entity.Commodity;
import com.muguang.ebusiness.entity.Goods;
import com.muguang.ebusiness.entity.Inventory;
import com.muguang.ebusiness.entity.ShopCommodity;
import com.muguang.ebusiness.feign.GoodsFeignClient;
import com.muguang.ebusiness.repository.impl.InventoryRepository;
import com.muguang.ebusiness.repository.impl.ShopCommodityRepository;
import com.muguang.ebusiness.service.IShopCommodityService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:14.
 */
@Service
public class ShopCommodityService implements IShopCommodityService{

    @Autowired
    private ShopCommodityRepository shopCommodityRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private GoodsFeignClient goodsFeignClient;

    @Override
    public ShopCommodity save(ShopCommodity sc) {
        return shopCommodityRepository.save(sc);
    }

    @Override
    public void updateStatus(long shopcommodityId, int status) {
        ShopCommodity sc = shopCommodityRepository.findById(shopcommodityId);
        if (sc==null || sc.getId()==0){
            throw new RuntimeException("ID为:"+shopcommodityId+"的商品不存在");
        }
        sc.setStatus(status);
        shopCommodityRepository.update(sc);
    }

    @Override
    public ShopCommodity createCommodityGoods(CreateShopCommodityParam param) {
        if (!param.valid()){
            throw  new RuntimeException("参数不能为null");
        }
        CreateCommodityParam commodityParam = param.getCommodity();
        List<CreateInventoryParam> inventories = param.getInventories();
        Commodity commodity = new Commodity();
        commodity.setBarcode(commodityParam.getBarcode());
        if (StringUtils.isBlank(commodity.getBarcode())){
            String ranBarcode = RandomStringUtils.random(12);
            commodity.setBarcode(ranBarcode);
        }
        commodity.setOutCode(commodityParam.getOutCode());
        commodity.setCategoryId(commodityParam.getCategoryId());
        commodity.setName(commodityParam.getName());
        commodity.setPic(commodityParam.getPic());
        commodity.setBasePrice(commodityParam.getBasePrice());
        commodity.setBaseWeight(commodityParam.getBaseWeight());
        commodity = goodsFeignClient.createCommodity(commodity);

        ShopCommodity sc = new ShopCommodity();
        sc.setCommodityId(commodity.getId());
        sc.setStatus(1);
        sc.setName(commodity.getName());
        sc = save(sc);
        for (CreateInventoryParam inventoryParam : inventories) {
            Goods goods = new Goods();
            goods.setCode(inventoryParam.getCode());
            if (StringUtils.isBlank(goods.getCode())){
                String ranCode = RandomStringUtils.random(12);
                goods.setCode(ranCode);
            }
            goods.setCommodityId(commodity.getId());
            goods.setSpecifications(inventoryParam.getSpecifications());
            goods.setPrice(inventoryParam.getPrice());
            goods.setWeight(inventoryParam.getWeight());
            goods = goodsFeignClient.createGoods(goods);

            Inventory inventory = new Inventory();
            inventory.setShopCommodityId(sc.getId());
            inventory.setGoodsId(goods.getId());
            inventory.setPrice(inventoryParam.getPrice());
            inventory.setWeight(inventoryParam.getWeight());
            inventory.setAmount(inventoryParam.getAmount());
            inventory.setStatus(inventoryParam.getStatus());
            inventoryRepository.save(inventory);
        }
        return sc;
    }

    @Override
    public List<ShopCommodity> findAll() {
        return shopCommodityRepository.findAll();
    }
}
