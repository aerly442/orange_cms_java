package com.gfrjxz.cms.util;
import com.gfrjxz.cms.entity.ReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RessponseMessge{

    public static ResponseEntity OK(Object data,String desc){
        ReturnType returnType = new ReturnType("0",desc,data);
        return new ResponseEntity<ReturnType>(returnType,HttpStatus.OK);
    }

    public static ResponseEntity Error(Object data,String desc){
        ReturnType returnType = new ReturnType("1",desc,data);
        return new ResponseEntity<ReturnType>(returnType,HttpStatus.OK);
    }
}