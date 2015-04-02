/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.tags;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author dubem
 */
public class Line extends SimpleTagSupport {

    private String id;
    private String cls;
    private String style;
    private String title;
    private String categories;
    private String yaxis;
    private String suffix;
    private String var;
    private String names;//comma separated values
    private String datas;//comma separated values

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     *
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            HTMLWriter w = new HTMLWriter();
            w.startElement(out, "div");
            w.attribute(out, "id", id);
            if (cls != null) {
                w.attribute(out, "class", cls);
            }
            if (style != null) {
                w.attribute(out, "style", style);
            }
            w.endElement(out, "div");
            w.startElement(out, "script");

            w.text(out, "function %sChart(url) {", var);
            w.text(out, "$.getJSON(url, function(%s) {", var);
            w.text(out, "$('#%s').highcharts({title: {text: '%s',x: -20},xAxis: {categories: %s.%s}", id, title, var, categories);
            w.text(out, ",yAxis: {min: 0,title: {text: '%s'},plotLines: [{value: 0,width: 1,color: '#808080'}]}", yaxis);
            if (suffix != null) {
                w.text(out, ",tooltip: {valueSuffix: '%s'}", suffix);
            }
            w.text(out, ",legend: {layout: 'vertical',align: 'right',verticalAlign: 'middle',borderWidth: 0}");

            String[] nms = this.names.split(",");
            String[] dts = this.datas.split(",");
            

            w.text(out, ",series: [");
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < nms.length; i++) {
                if (i > 0) {
                    buf.append(",");
                }
                buf.append(String.format("{name: '%s',data: %s.%s}", nms[i],var,dts[i]));
            }
            w.fragment(out, getJspBody());//series

            w.text(out, buf.toString()+"]});});}");
            w.endElement(out, "script");
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Line tag", ex);
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setYaxis(String yaxis) {
        this.yaxis = yaxis;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

}
