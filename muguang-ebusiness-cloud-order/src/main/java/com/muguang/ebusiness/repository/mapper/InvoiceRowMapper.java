package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Invoice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017-3-7 22:01
 */
public class InvoiceRowMapper implements RowMapper<Invoice>{
    @Override
    public Invoice mapRow(ResultSet rs, int i) throws SQLException {
        Invoice invoice = null;
        long id = rs.getLong("id");
        if (id!=0){
            invoice = new Invoice();
            invoice.setId(id);
            invoice.setOrderId(rs.getLong("order_id"));
            invoice.setOrderSerialno(rs.getString("order_serialno"));
            invoice.setInvoicetypeId(rs.getShort("invoicetype_id"));
            invoice.setCost(rs.getInt("cost"));
            invoice.setStatus(rs.getShort("status"));
            invoice.setPrintTimes(rs.getInt("print_times"));
        }
        return invoice;
    }
}
