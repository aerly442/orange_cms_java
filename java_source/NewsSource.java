package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class NewsSource {


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
private String title;
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
//@NotEmpty(message = "")
/* */
private String note;
public String getNote() {
    return note;
}
public void setNote(String note) {
    this.note = note;
}
//@NotEmpty(message = "")
/* */
private String url;
public String getUrl() {
    return url;
}
public void setUrl(String url) {
    this.url = url;
}
//@NotEmpty(message = "")
/* */
private String type;
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
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
"title":"",
"note":"",
"url":"",
"type":"",
"createtime":"",
"updatetime":"",


}

*/
    
}
