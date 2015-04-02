/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.table;

import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**builds and executes native query for front end tables.you are 100% responsible for constructing the query in the right syntax.this is a query gun,don't shoot urself in the foot
 *
 * @author dubem
 */
public class TableQuery {
    
    private final StringBuilder mainsql;
    private final StringBuilder countsql;
    private boolean selected = false;
    private boolean hasWhere;
    private boolean hasHaving;

    public TableQuery() {
        mainsql = new StringBuilder();
        countsql = new StringBuilder();
    }

    /**
     *
     * @param table the table(s) name
     * @param colStr a comma separated column list as is in database
     * @return
     */
    public TableQuery select(String table, String colStr) {
        if (selected) {
            throw new IllegalStateException("select has been created already");
        }
        mainsql.append("select ").append(colStr.trim()).append(" from ").append(table.trim());
        countsql.append("select count(*) from ").append(table.trim());
        selected = true;
        return this;
    }
    
    public TableQuery select(String table, String[] cols) {
        if (selected) {
            throw new IllegalStateException("select has been created already");
        }
        mainsql.append("select ").append(StringUtils.arrayToCommaDelimitedString(cols)).append(" from ").append(table.trim());
        countsql.append("select ").append(StringUtils.arrayToCommaDelimitedString(cols)).append(" from ").append(table.trim());
        selected = true;
        return this;
    }
    
    public TableQuery filter(String colStr, String keyword){
        if(StringUtils.isEmpty(keyword)){
            return this;
        }
        whereAnd();
        int count = 1;
        String[] cols = colStr.split(",");
        mainsql.append(" (");
        countsql.append(" (");
        for (String col : cols) {
            mainsql.append(col).append(" like '%").append(keyword).append("%'");
            countsql.append(col).append(" like '%").append(keyword).append("%'");
            if (count < cols.length) {
                mainsql.append(" or ");
                countsql.append(" or ");
            }
            count++;
        }
        mainsql.append(")");
        countsql.append(")");
        return this;
    }
    
    public TableQuery sort(String colname,boolean asc){
        mainsql.append(" order by ").append(colname);
        if (!asc) {
            mainsql.append(" desc ");
        }
        return this;
    }
    
    public TableQuery limit(int start,int size){
        mainsql.append(" limit ").append(start).append(",").append(size);
        return this;
    }
//    public TableQuery search(List<Search> searchList, String[] cols){
//        for (Search search : searchList) {
//            
//        }
//        mainsql.append(" order by ").append(colname);
//        if (!asc) {
//            mainsql.append(" desc ");
//        }
//        return this;
//    }
//    
    public String[] results(){
        System.out.println("sql - "+mainsql.toString());
        return new String[]{mainsql.toString(),countsql.toString()};
    }
    
    public TableQuery where(String wStr){
        whereAnd();
        mainsql.append(wStr);
        countsql.append(wStr);
        return this;
    }
    
    public TableQuery where(String key,String operator,String value){
        if(StringUtils.isEmpty(value)){
            return this;
        }
        whereAnd();
        mainsql.append(key).append(operator).append("'").append(value).append("'");
        countsql.append(key).append(operator).append("'").append(value).append("'");
        return this;
    }
    
    public TableQuery where(String key,String operator,int value){
        
        whereAnd();
        mainsql.append(key).append(operator).append(value);
        countsql.append(key).append(operator).append(value);
        return this;
    }
    
    
    private void whereAnd() {
        if (!this.hasWhere) {
            this.mainsql.append(" WHERE ");
            this.countsql.append(" WHERE ");
            this.hasWhere = true;
            return;
        }
        this.mainsql.append(" AND ");
        this.countsql.append(" AND ");
    }

    private void havingAnd() {
        if (!this.hasHaving) {
            this.mainsql.append(" HAVING ");
            this.countsql.append(" HAVING ");
            this.hasHaving = true;
            return;
        }
        this.mainsql.append(" AND ");
        this.countsql.append(" AND ");
    }
    
    public static void main(String[] hhhs){
        TableQuery tq = new TableQuery();
        String[] results = tq.select("persons", "name,age,sex")
                .filter("name,age,sex", "se")
                .where("name", "=", "dubic")
                .sort("age", true)
                .limit(0, 10).results();
        System.out.println(results[0]);
        
//        System.out.println(page);
    }

    public TableQuery groupBy(String string) {
        mainsql.append(" GROUP BY ").append(string);
        return this;
    }

}
