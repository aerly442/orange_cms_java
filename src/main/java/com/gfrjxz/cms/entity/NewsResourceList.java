package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class NewsResourceList {


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
private int newsid;
public int getNewsid() {
    return newsid;
}
public void setNewsid(int newsid) {
    this.newsid = newsid;
}
//@NotEmpty(message = "")
/* */
private int newsresourceid;
public int getNewsresourceid() {
    return newsresourceid;
}
public void setNewsresourceid(int newsresourceid) {
    this.newsresourceid = newsresourceid;
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
private String updatetime;
public String getUpdatetime() {
    return updatetime;
}
public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
}

    

    
    
 
/* json 
{
  
  "id":"",
"newsid":"",
"newsresourceid":"",
"createtime":"",
"updatetime":"",


}

*/
    
}
