/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.controllers;

import com.dubic.scribbles.admin.dto.Token;
import com.dubic.scribbles.admin.services.DB;
import com.dubic.scribbles.admin.services.utils.Util;
import com.dubic.scribbles.admin.table.Table;
import com.dubic.scribbles.admin.table.TableQuery;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dubem
 */
@Controller
@RequestMapping("/tokens")
public class TokensController {

    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private DB db;

    @RequestMapping("/page")
    public String pageLoad(@RequestParam("p") String page) {
        return "tokens/" + page;
    }

    @RequestMapping("/table")
    public @ResponseBody
    JsonObject tokensTable(@RequestBody Table dt) {
        System.out.println(new Gson().toJson(dt));
        String[] cols = "t.id,t.token,u.screen_name,t.active,t.type,t.create_dt,t.expiry_dt,t.used_dt".split(",");
        TableQuery tq = new TableQuery()
                .select("tokens t,users u ", "t.id,t.token,u.screen_name,if(t.active,'true','false') as active,t.type,t.create_dt,t.expiry_dt,t.used_dt")
                .where("t.user_id=u.id");
//                .where("u.state_name", "=", dt.getSearch() == null ? null : dt.getSearch().getState())
//                .where("u.ward_name", "=", dt.getSearch() == null ? null : dt.getSearch().getWard())
//                .where("u.lga_name", "=", dt.getSearch() == null ? null : dt.getSearch().getLga())
//                .where("u.polling_station_name", "=", dt.getSearch() == null ? null : dt.getSearch().getUnit());

        String[] results = tq.filter("t.token,u.screen_name,t.active,t.type", dt.getFilter())
                .sort(cols[dt.getSortcol()], dt.isSortasc()).limit(dt.getStart(), dt.getSize()).results();
        List<Token> tokens = db.getList(results[0], new RowMapper<Token>() {
            @Override
            public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
                Token t = new Token();
                t.setId(rs.getLong("id"));
                t.setActive(rs.getString("active"));
                t.setCreateDate(Util.formatDate(rs.getTimestamp("create_dt")));
                t.setExpDate(Util.formatDate(rs.getTimestamp("expiry_dt")));
                t.setToken(rs.getString("token"));
                t.setType(rs.getString("type"));
                t.setUser(rs.getString("screen_name"));
                t.setUsedDate(Util.formatDate(rs.getTimestamp("used_dt")));
                return t;
            }
        });

        JsonObject resp = new JsonObject();
        resp.addProperty("total", db.count(results[1]));
        resp.add("tokens", new Gson().toJsonTree(tokens));

        return resp;
    }

    @RequestMapping("/stats")
    public @ResponseBody
    JsonObject stats() {
        JsonObject resp = new JsonObject();
//        resp.addProperty("all", db.count("select count(t.id) from users u"));
        resp.addProperty("active", db.count("select count(t.id) from tokens t where t.active=true"));

        return resp;
    }

}
