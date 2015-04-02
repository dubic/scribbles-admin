/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.services;

import com.dubic.scribbles.admin.dto.Token;
import com.dubic.scribbles.admin.dto.UserData;
import com.dubic.scribbles.admin.services.utils.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author dubem
 */
public class DB {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   

//    public List<Object[]> getUsersTable(String sql, RowMapper<Object[]> rowMapper) {
//        return jdbcTemplate.query(sql, rowMapper);
//    }

    public Integer count(String sql) {
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Object[]> getObjectList(String sql, RowMapper<Object[]> rowMapper) {
        return jdbcTemplate.query(sql, rowMapper);
    }

    public UserData getUserById(String sql) {
        return jdbcTemplate.queryForObject(sql, new RowMapper<UserData>() {

            @Override
            public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserData u = new UserData();
                u.setId(rs.getLong("id"));
                u.setScreenName(rs.getString("screen_name"));
                u.setEmail(rs.getString("email"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setPicture(rs.getString("picture"));
                u.setJokes(rs.getLong("jokes"));
                u.setQuotes(rs.getLong("quotes"));
                u.setProverbs(rs.getLong("proverbs"));
                u.setUpdated(Util.formatDate(rs.getTimestamp("updated")));
                return u;
            }
        });
    }

    public <T> List<T> getList(String sql, RowMapper<T> rowMapper) {
        return jdbcTemplate.query(sql, rowMapper);
    }

}
