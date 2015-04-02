/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.controllers;

import com.dubic.scribbles.admin.dto.Token;
import com.dubic.scribbles.admin.dto.UserData;
import com.dubic.scribbles.admin.services.DB;
import com.dubic.scribbles.admin.services.utils.Util;
import com.dubic.scribbles.admin.table.Table;
import com.dubic.scribbles.admin.table.TableQuery;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
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
@RequestMapping("/users")
public class UserController {

    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private DB db;

    @RequestMapping("/page")
    public String pageLoad(@RequestParam("p") String page) {
        return "users/" + page;
    }

    @RequestMapping("/table")
    public @ResponseBody
    JsonObject usersTable(@RequestBody Table dt) {
        System.out.println(new Gson().toJson(dt));
        String[] cols = "u.id, u.screen_name,u.active,u.last_login_dt,u.create_dt".split(",");
        TableQuery tq = new TableQuery()
                .select("users u ", "u.id, u.screen_name,IF(u.active,'true','false') as active,u.last_login_dt,u.create_dt");
//                .where("u.state_name", "=", dt.getSearch() == null ? null : dt.getSearch().getState())
//                .where("u.ward_name", "=", dt.getSearch() == null ? null : dt.getSearch().getWard())
//                .where("u.lga_name", "=", dt.getSearch() == null ? null : dt.getSearch().getLga())
//                .where("u.polling_station_name", "=", dt.getSearch() == null ? null : dt.getSearch().getUnit());

        String[] results = tq.filter("u.id, u.screen_name,u.active,u.last_login_dt,u.create_dt", dt.getFilter())
                .sort(cols[dt.getSortcol()], dt.isSortasc()).limit(dt.getStart(), dt.getSize()).results();
        List<Object[]> users = db.getObjectList(results[0], new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Object[]{
                    rs.getLong("id"),
                    rs.getString("screen_name"),
                    rs.getString("active"),
                    Util.formatDate(rs.getTimestamp("last_login_dt")),
                    Util.formatDate(rs.getTimestamp("create_dt"))
                };
            }
        });

        JsonObject resp = new JsonObject();
        resp.addProperty("total", db.count(results[1]));
        resp.add("users", new Gson().toJsonTree(users));

        return resp;
    }

    @RequestMapping("/chart")
    public @ResponseBody
    JsonObject usersChart(@RequestParam("m") int month) {
        int sqlMonth = month == -1 ? Util.currentMonth() : month;
        String sql = "select DAY(u.create_dt) as daymonth,count(u.id) as count from users u\n"
                + "where MONTH(u.create_dt)=" + (sqlMonth + 1) + "\n"
                + "group by DAY(u.create_dt)";
        List<Object[]> users = db.getObjectList(sql, new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Object[]{
                    rs.getInt("daymonth"),
                    rs.getInt("count")
                };
            }
        });
        JsonObject resp = new JsonObject();
        JsonArray cats = new JsonArray();
        JsonArray data = new JsonArray();
        for (Object[] o : users) {
            cats.add(new JsonPrimitive((Integer) o[0]));
            data.add(new JsonPrimitive((Integer) o[1]));
        }
        resp.add("categories", cats);
        resp.add("data", data);
        resp.addProperty("month", sqlMonth);

        return resp;
    }

    @RequestMapping("/stats")
    public @ResponseBody
    JsonObject stats() {
        JsonObject resp = new JsonObject();
        resp.addProperty("all", db.count("select count(u.id) from users u"));
        resp.addProperty("active", db.count("select count(u.id) from users u where u.active=true"));

        return resp;
    }

    @RequestMapping("/profile")
    public @ResponseBody
    UserData profile(@RequestParam("id") Long id) {
        JsonObject resp = new JsonObject();
        String sql = "select u.id,u.email,u.screen_name,u.firstname,u.lastname,u.picture,p.jokes,p.proverbs,p.quotes,p.updated from users u,profile p\n"
                + "where u.profile_id=p.id and p.id=" + id;
        return db.getUserById(sql);
    }
    
    
}
