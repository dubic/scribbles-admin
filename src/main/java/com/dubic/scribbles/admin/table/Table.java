/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dubic.scribbles.admin.table;

/**
 *
 * @author dubem
 */
public class Table {
    private int size;
    private int start;
    private Long total;
    private String filter;
    private int sortcol;
    private boolean sortasc;
    private Search search;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public int getSortcol() {
        return sortcol;
    }

    public void setSortcol(int sortcol) {
        this.sortcol = sortcol;
    }

    public boolean isSortasc() {
        return sortasc;
    }

    public void setSortasc(boolean sortasc) {
        this.sortasc = sortasc;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
    

    @Override
    public String toString() {
        return "Table{" + "size=" + size + ", start=" + start + ", total=" + total + ", filter=" + filter + ", sortcol=" + sortcol + ", sortasc=" + sortasc + '}';
    }

   
    
    
}
