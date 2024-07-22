package com.gfrjxz.cms.controller;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;  
  
@Controller  
//@RequestMapping("/hello")
public class HelloController {  
  
    @GetMapping("/hello")  
    public String hello(Model model) {  
        model.addAttribute("name", "World");  
        return "hello"; // 返回模板文件名，不包含后缀  
    }  
}
