package com.gfrjxz.cms.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Manager {

    //自增ID
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty(message = "用户名是必须的")
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "密码是必须的")
    @NotEmpty(message = "密码是必须的123",groups = {ValidUpdateGroup.class})
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String tel;
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }




    private String depart;
    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }

    private int power;
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    private String lastlogindatetime;
    public String getLastlogindatetime() {
        return lastlogindatetime;
    }
    public void setLastlogindatetime(String lastlogindatetime) {
        this.lastlogindatetime = lastlogindatetime;
    }



    private String lastloginip;
    public String getLastloginip() {
        return lastloginip;
    }
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

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
"username":"",
"password":"",
"name":"",
"tel":"",
"depart":"",
"power":"",
"lastlogindatetime":"",
"c_role_id":"",
"lastloginip":"",
"createtime":"",
"corpid":"",
}

*/

}
