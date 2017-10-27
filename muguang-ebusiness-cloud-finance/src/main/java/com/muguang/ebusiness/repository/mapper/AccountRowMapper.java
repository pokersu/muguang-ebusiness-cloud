package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 14:07.
 */
public class AccountRowMapper implements RowMapper<Account>{
    @Override
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        Account account = null;
        long id = rs.getLong("id");
        if (id!=0){
            account = new Account();
            account.setId(id);
            account.setUserId(rs.getLong("user_id"));
            account.setType(rs.getInt("type"));
            account.setBalance(rs.getInt("balance"));
            account.setBlockedBalances(rs.getInt("blocked_balances"));
            account.setPassword(rs.getString("password"));
            account.setSalt(rs.getString("salt"));
        }
        return account;
    }
}
