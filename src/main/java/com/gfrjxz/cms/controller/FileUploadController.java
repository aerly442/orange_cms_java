package com.gfrjxz.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.multipart.MultipartFile;

import java.io.File;  
import java.io.IOException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
import java.nio.file.Paths;  

import com.gfrjxz.cms.util.*;
 
  
@RestController  
@RequestMapping("fileUpload")
public class FileUploadController {  
  
    private static final String TARGET_FOLDER = "src/main/resources/static/upload";  

  

    @PostMapping("/upload")  
    public Object handleFileUpload(@RequestParam("file") MultipartFile file) {  
        if (file.isEmpty()) {  
            return ResponseEntity.status(400).body("File is empty");  
        }  

        // 获取文件名并构建存储路径  
        String SuccessJson = "#filePath#";  
        SuccessJson = this.UploadImage(file,SuccessJson) ; 
        if (SuccessJson.isEmpty() == false ){
            return RessponseMessge.OK(SuccessJson, "ok");
        }
        else{

            return RessponseMessge.OK("0", "上传错误");

        }


         
    } 
    
    @GetMapping("/uploadForEditor")  
    public Object editorFileUpload(){


         String DefaultJson = "{\r\n\t\"imageActionName\": \"uploadForEditor\",\r\n\t\"imageFieldName\": \"file\",\r\n\t\"imageMaxSize\": 2048000,\r\n\t\"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"imageCompressEnable\": true,\r\n\t\"imageCompressBorder\": 1600,\r\n\t\"imageInsertAlign\": \"none\",\r\n\t\"imageUrlPrefix\": \"\",\r\n\t\"imagePathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"scrawlActionName\": \"uploadscrawl\",\r\n\t\"scrawlFieldName\": \"upfile\",\r\n\t\"scrawlPathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"scrawlMaxSize\": 2048000,\r\n\t\"scrawlUrlPrefix\": \"\",\r\n\t\"scrawlInsertAlign\": \"none\",\r\n\t\"snapscreenActionName\": \"uploadimage\",\r\n\t\"snapscreenPathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"snapscreenUrlPrefix\": \"\",\r\n\t\"snapscreenInsertAlign\": \"none\",\r\n\t\"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\r\n\t\"catcherActionName\": \"catchimage\",\r\n\t\"catcherFieldName\": \"source\",\r\n\t\"catcherPathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"catcherUrlPrefix\": \"\",\r\n\t\"catcherMaxSize\": 2048000,\r\n\t\"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"videoActionName\": \"uploadvideo\",\r\n\t\"videoFieldName\": \"upfile\",\r\n\t\"videoPathFormat\": \"/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"videoUrlPrefix\": \"\",\r\n\t\"videoMaxSize\": 102400000,\r\n\t\"fileActionName\": \"uploadfile\",\r\n\t\"fileFieldName\": \"upfile\",\r\n\t\"filePathFormat\": \"/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"fileUrlPrefix\": \"\",\r\n\t\"fileMaxSize\": 51200000,\r\n\t\"fileAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"imageManagerActionName\": \"listimage\",\r\n\t\"imageManagerListPath\": \"/upload/image/\",\r\n\t\"imageManagerListSize\": 20,\r\n\t\"imageManagerUrlPrefix\": \"\",\r\n\t\"imageManagerInsertAlign\": \"none\",\r\n\t\"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"fileManagerActionName\": \"listfile\",\r\n\t\"fileManagerListPath\": \"/upload/file/\",\r\n\t\"fileManagerUrlPrefix\": \"\",\r\n\t\"fileManagerListSize\": 20,\r\n\t\"fileManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"]\r\n}";

         return DefaultJson ;
    }

    private String UploadImage(MultipartFile file,String successJson){

        try{
            File  myFile            = new File(TARGET_FOLDER);
            String realPath         = myFile.getCanonicalPath();
            String fileName         = DateCommon.getNowToday3();
            String ext              = StrUtil.GetFileExt( file.getOriginalFilename());
            String uploadFileName   = "/upload/"+fileName+"."+ext;
            file.transferTo(new File(realPath+"/"+fileName+"."+ext));
            successJson = successJson.replace("#filePath#", uploadFileName);
            successJson = successJson.replace("#fileName#", fileName+"."+ext);
            return successJson;
        }
        catch(IOException e)
        {
            return "";
        }
    }

    //public string DefaultJson = "{\r\n\t\"imageActionName\": \"uploadimage\",\r\n\t\"imageFieldName\": \"upfile\",\r\n\t\"imageMaxSize\": 2048000,\r\n\t\"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"imageCompressEnable\": true,\r\n\t\"imageCompressBorder\": 1600,\r\n\t\"imageInsertAlign\": \"none\",\r\n\t\"imageUrlPrefix\": \"\",\r\n\t\"imagePathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"scrawlActionName\": \"uploadscrawl\",\r\n\t\"scrawlFieldName\": \"upfile\",\r\n\t\"scrawlPathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"scrawlMaxSize\": 2048000,\r\n\t\"scrawlUrlPrefix\": \"\",\r\n\t\"scrawlInsertAlign\": \"none\",\r\n\t\"snapscreenActionName\": \"uploadimage\",\r\n\t\"snapscreenPathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"snapscreenUrlPrefix\": \"\",\r\n\t\"snapscreenInsertAlign\": \"none\",\r\n\t\"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\r\n\t\"catcherActionName\": \"catchimage\",\r\n\t\"catcherFieldName\": \"source\",\r\n\t\"catcherPathFormat\": \"/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"catcherUrlPrefix\": \"\",\r\n\t\"catcherMaxSize\": 2048000,\r\n\t\"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"videoActionName\": \"uploadvideo\",\r\n\t\"videoFieldName\": \"upfile\",\r\n\t\"videoPathFormat\": \"/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"videoUrlPrefix\": \"\",\r\n\t\"videoMaxSize\": 102400000,\r\n\t\"fileActionName\": \"uploadfile\",\r\n\t\"fileFieldName\": \"upfile\",\r\n\t\"filePathFormat\": \"/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\r\n\t\"fileUrlPrefix\": \"\",\r\n\t\"fileMaxSize\": 51200000,\r\n\t\"fileAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"imageManagerActionName\": \"listimage\",\r\n\t\"imageManagerListPath\": \"/upload/image/\",\r\n\t\"imageManagerListSize\": 20,\r\n\t\"imageManagerUrlPrefix\": \"\",\r\n\t\"imageManagerInsertAlign\": \"none\",\r\n\t\"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\r\n\t\"fileManagerActionName\": \"listfile\",\r\n\t\"fileManagerListPath\": \"/upload/file/\",\r\n\t\"fileManagerUrlPrefix\": \"\",\r\n\t\"fileManagerListSize\": 20,\r\n\t\"fileManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"]\r\n}";
    @PostMapping("/uploadForEditor")  
    public Object editorFileUpload(@RequestParam("file") MultipartFile file){


        String SuccessJson = "{\r\n    \"state\": \"SUCCESS\",\r\n\t\t\t\t\"url\": \"#filePath#\",\r\n\t\t\t\t\"title\": \"#fileName#\",\r\n\t\t\t\t\"original\": \"#fileName#\",\r\n\t\t\t\t\"type\": \".jpg\",\r\n\t\t\t\t\"size\": 166049\r\n}";
       
        SuccessJson = this.UploadImage(file,SuccessJson) ; 
        return SuccessJson;


         
    }
}