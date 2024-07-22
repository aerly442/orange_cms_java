package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.service.CreateCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private CreateCodeService createCodeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Object index(@RequestParam String tableName) throws Exception {

        String r = createCodeService.CreateDaoFile(tableName,"com.gfrjxz.cms");
         r   += createCodeService.CreateControllerFile(tableName,"com.gfrjxz.cms");
         r   += createCodeService.CreateEntityFile(tableName,"com.gfrjxz.cms");
         r   += createCodeService.CreateServiceFile(tableName,"com.gfrjxz.cms");
        logger.error("run this line");
        logger.error(r);
        return "自动生产代码:"+r;
        
    }
    
}
