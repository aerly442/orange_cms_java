package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class NewsResourceListDTO {


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


private String title;
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}


private String ctitle;
public String getCtitle() {
    return ctitle;
}
public void setCtitle(String ctitle) {
    this.ctitle = ctitle;
}


private String resource;
public String getResource() {
    return resource;
}
public void setResource(String resource) {
    this.resource = resource;
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
