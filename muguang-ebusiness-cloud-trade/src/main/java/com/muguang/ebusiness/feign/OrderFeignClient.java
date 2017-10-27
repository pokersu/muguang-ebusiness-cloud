package com.muguang.ebusiness.feign;

import com.muguang.ebusiness.entity.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author muguang
 * @date 2017/3/8 14:37.
 */
@FeignClient(name="yokimi-ebusiness-cloud-order")
public interface OrderFeignClient {

    @RequestMapping(path = "/order/status", method = RequestMethod.PUT)
    void successProcess(@RequestParam("serialno") String serialno, @RequestParam("status") short status, @RequestParam("payStatus") short payStatus);

    @RequestMapping(path = "/order/serialno/{serialno}", method = RequestMethod.GET)
    Order findBySerialno(@PathVariable("serialno") String serialno);
}
