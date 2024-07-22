package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class NewsTag {


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
private String tag;
public String getTag() {
    return tag;
}
public void setTag(String tag) {
    this.tag = tag;
}
//@NotEmpty(message = "")
/* */
private int newsId;
public int getNewsId() {
    return newsId;
}
public void setNewsId(int newsId) {
    this.newsId = newsId;
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

    

    
    
 
/* json 
{
  
  "id":"",
"tag":"",
"newsId":"",
"createtime":"",


}

*/
    
}
