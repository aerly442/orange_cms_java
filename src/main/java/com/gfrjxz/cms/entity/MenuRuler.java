package com.gfrjxz.cms.entity;
 
import java.util.Date;


public class MenuRuler {


  //@NotEmpty(message = "")
/* */
private int id;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
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
private String username;
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
//@NotEmpty(message = "")
/* */
private String menuid;
public String getMenuid() {
    return menuid;
}
public void setMenuid(String menuid) {
    this.menuid = menuid;
}
//@NotEmpty(message = "")
/* */
private int managerid;
public int getManagerid() {
    return managerid;
}
public void setManagerid(int managerid) {
    this.managerid = managerid;
}

    

    
    
 
/* json 
{
  
  "id":"",
"createtime":"",
"username":"",
"menuid":"",
"managerid":"",


}

*/
    
}
