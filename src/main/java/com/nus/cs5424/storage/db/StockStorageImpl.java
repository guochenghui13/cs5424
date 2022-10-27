/**
 * @(#)StockStorageImpl.java, Oct 27, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nus.cs5424.storage.db;

import com.nus.cs5424.data.Stock;
import com.nus.cs5424.storage.BaseStorage;
import com.nus.cs5424.storage.StockStorage;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author guochenghui
 */
@Repository
public class StockStorageImpl extends BaseStorage implements StockStorage {

    private static final String TABLE = "\"Stock\"";

    @Override
    public Stock query(int s_w_id, int s_i_id) {
        String sql = String.format("SELECT * FROM " + TABLE + " WHERE \"S_W_ID\" = %d AND \"S_I_ID\" = %d", s_w_id, s_i_id);
        System.out.println(sql);
        Stock stock = jdbcTemplate.queryForObject(sql, new RowMapper<Stock>() {
            @Override
            public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
                Stock stock = new Stock();
                stock.setId(rs.getInt("S_W_ID"));
                stock.setS_i_id(rs.getInt("S_I_ID"));
                // TODO: 完成剩下的
                return stock;
            }
        });
        return stock;
    }
}