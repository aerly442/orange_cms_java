package com.gfrjxz.cms.entity;

import java.util.Date;

public class Menu {

    // @NotEmpty(message = "编号")
    /* 编号 */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // @NotEmpty(message = "名称")
    /* 名称 */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @NotEmpty(message = "类型")
    /* 类型 */
    private String cssclass;

    public String getCssclass() {
        return cssclass;
    }

    public void setCssclass(String cssclass) {
        this.cssclass = cssclass;
    }

    // @NotEmpty(message = "链接")
    /* 链接 */
    private String linktext;

    public String getLinktext() {
        return linktext;
    }

    public void setLinktext(String linktext) {
        this.linktext = linktext;
    }

    // @NotEmpty(message = "父类ID")
    /* 父类ID */
    private int parentid;

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    // @NotEmpty(message = "创建时间")
    /* 创建时间 */
    private String createtime;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    // @NotEmpty(message = "排序")
    /* 排序 */
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    /*
     * json
     * {
     * 
     * "id":"",
     * "name":"",
     * "cssclass":"",
     * "linktext":"",
     * "parentid":"",
     * "createtime":"",
     * "sort":"",
     * 
     * 
     * }
     * 
     */

}
