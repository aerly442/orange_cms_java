package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class NewsResourceVisitReport {


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
private String updatetime;
public String getUpdatetime() {
    return updatetime;
}
public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
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
private String reporttime;
public String getReporttime() {
    return reporttime;
}
public void setReporttime(String reporttime) {
    this.reporttime = reporttime;
}
//@NotEmpty(message = "")
/* */
private int clickPv;
public int getClickPv() {
    return clickPv;
}
public void setClickPv(int clickPv) {
    this.clickPv = clickPv;
}

    

    
    
 
/* json 
{
  
  "id":"",
"createtime":"",
"updatetime":"",
"title":"",
"reporttime":"",
"clickPv":"",


}

*/
    
}
