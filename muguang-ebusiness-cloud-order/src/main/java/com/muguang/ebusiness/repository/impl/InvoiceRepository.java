package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Invoice;
import com.muguang.ebusiness.repository.IInvoiceRepository;
import com.muguang.ebusiness.repository.mapper.InvoiceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017-3-7 21:51
 */
@Repository
public class InvoiceRepository implements IInvoiceRepository{

    private static final String FindById = "select * from invoice";
    private static final String FindByOrderId = "select * from invoice where order_id=?";
    private static final String Save = "insert into invoice (order_id, order_serialno, invoicetype_id, cost, status, print_times) value(?, ?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Invoice findById(long id) {
        return jdbcTemplate.queryForObject(FindById , new InvoiceRowMapper());
    }

    @Override
    public Invoice findByOrderId(long orderId) {
        return jdbcTemplate.queryForObject(FindByOrderId, new Object[]{orderId}, new InvoiceRowMapper());
    }

    @Override
    public Invoice save(Invoice invoice) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save);
                ps.setLong(1, invoice.getOrderId());
                ps.setString(2, invoice.getOrderSerialno());
                ps.setInt(3, invoice.getInvoicetypeId());
                ps.setInt(4, invoice.getCost());
                ps.setShort(5, invoice.getStatus());
                ps.setInt(6, invoice.getPrintTimes());
                return ps;
            }
        }, keyHolder);
        invoice.setId(keyHolder.getKey().longValue());
        return invoice;
    }
}
