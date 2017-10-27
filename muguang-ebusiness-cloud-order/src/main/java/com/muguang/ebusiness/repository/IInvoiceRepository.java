package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Invoice;

/**
 * @author muguang
 * @date 2017-3-7 21:50
 */
public interface IInvoiceRepository {

    Invoice findById(long id);
    Invoice findByOrderId(long orderId);
    Invoice save(Invoice invoice);
}
