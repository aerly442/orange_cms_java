package com.gfrjxz.cms.entity;
 

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


public class NewsCategories {


  //@NotEmpty(message = "")
/* */
private int id;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
@NotEmpty(message = "名称是必须的")
/* */
private String name;
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
//@NotEmpty(message = "")
@NotEmpty(message = "代码是必须的")
/* */
private String code;
public String getCode() {
    return code;
}
public void setCode(String code) {
    this.code = code;
}
//@NotEmpty(message = "")
/* */
private String createtime;
public String getCreatetime() {
    return createtime;
}
public void setCreatetime(String createtime) {
    this.createtime = createtime;
}
//@NotEmpty(message = "")
/* */
private int sort;
public int getSort() {
    return sort;
}
public void setSort(int sort) {
    this.sort = sort;
}

    

    
    
 
/* json 
{
  
  "id":"",
"name":"",
"code":"",
"createtime":"",
"sort":"",


}

*/
    
}
