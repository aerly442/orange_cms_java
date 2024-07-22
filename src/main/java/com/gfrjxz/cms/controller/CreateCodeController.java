package com.gfrjxz.cms.controller;


import com.gfrjxz.cms.config.Consts;
import com.gfrjxz.cms.entity.*;


import com.gfrjxz.cms.exception.UserException;
import com.gfrjxz.cms.service.CreateCodeService;
import com.gfrjxz.cms.service.ManagerService;

import com.gfrjxz.cms.util.RessponseMessge;

import com.gfrjxz.cms.util.StrUtil;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gfrjxz.cms.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("create_code")
//@CrossOrigin(origins = "*")
public class CreateCodeController {

    @Autowired
    private CreateCodeService createCodeService;

    @Autowired
    private HttpServletRequest request;

    //01 登录接口
    //@CrossOrigin(origins = "*")
    @RequestMapping(value="/get_table",method = RequestMethod.GET)
    public Object getTable(){

        List<String> lstResult = createCodeService.getTable();
        return RessponseMessge.OK(lstResult, "登录成功");

    }
    //02 获取表描述
    //@CrossOrigin(origins = "*")
    @RequestMapping(value="/get_table_desc",method = RequestMethod.GET)
    public Object getTableDesc(@RequestParam String tableName){

        List<Map<String,Object>> lstResult = createCodeService.getTableDesc(tableName);
        return RessponseMessge.OK(lstResult, "登录成功");

    }

    @RequestMapping(value="/start",method = RequestMethod.POST)
    public Object start(@RequestBody  @Validated CreateCodeDTO createCodeDTO) throws UserException{
        createCodeService.start(createCodeDTO);
        return RessponseMessge.OK(null, "成功");

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Object index(@RequestParam String tableName) throws Exception {

        String r = "Dao文件：\r\n";
         r   +=createCodeService.CreateDaoFile(tableName,"com.gfrjxz.cms");
         r   +="Controller文件：\r\n";
         r   += createCodeService.CreateControllerFile(tableName,"com.gfrjxz.cms");
         r   +="Entity文件：\r\n";
         r   += createCodeService.CreateEntityFile(tableName,"com.gfrjxz.cms");
         r   +="Service文件：\r\n";
         r   += createCodeService.CreateServiceFile(tableName,"com.gfrjxz.cms");
        //logger.error("run this line");
        //logger.error(r);
        return "自动生产代码:"+r;
        
    }
}
