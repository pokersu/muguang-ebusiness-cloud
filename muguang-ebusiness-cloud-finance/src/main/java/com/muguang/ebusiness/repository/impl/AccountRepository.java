package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Account;
import com.muguang.ebusiness.repository.IAccountRepository;
import com.muguang.ebusiness.repository.mapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author muguang
 * @date 2017/3/7 14:07.
 */
@Repository
public class AccountRepository implements IAccountRepository{


    private static final String FindByUserId = "select * from account where user_id=?";
    private static final String Save = "insert into account(user_id, type, balance, blocked_balances, password, salt) value(?, ?, ?, ?, ?, ?)";
    private static final String UpateBalance = "update account set balance=? where user_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findByUserId(Long userId) {
        return jdbcTemplate.queryForObject(FindByUserId, new Object[]{userId}, new AccountRowMapper());
    }

    @Override
    public Account save(Account account) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, account.getUserId());
                ps.setInt(2, account.getType());
                ps.setInt(3, account.getBalance());
                ps.setInt(4, account.getBlockedBalances());
                ps.setString(5, account.getPassword());
                ps.setString(6, account.getSalt());
                return ps;
            }
        }, keyHolder);
        account.setId(keyHolder.getKey().longValue());
        return account;
    }

    @Override
    public void updateBalance(Account account) {
        jdbcTemplate.update(UpateBalance, new Object[]{account.getBalance(), account.getUserId()});
    }
}
