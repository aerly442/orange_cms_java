package com.gfrjxz.cms.service;

import com.alibaba.druid.util.StringUtils;
import com.gfrjxz.cms.dao.CreateCodeDao;
import com.gfrjxz.cms.dao.ManagerDao;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.exception.UserException;
import com.gfrjxz.cms.util.EncryptUtil;
import com.gfrjxz.cms.util.RessponseMessge;
import com.gfrjxz.cms.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.constraints.NotEmpty;
import javax.websocket.Decoder;

@Service
public class CreateCodeService {

    @Autowired
    private CreateCodeDao createCodeDao;

    // 获取所有的表名称
    public List<String> getTable() {

        return createCodeDao.getTable();

    }

    public List<Map<String, Object>> getTableDesc(String tableName) {
        return createCodeDao.getTableDesc(tableName);
    }

    // 创建代码模板
    public void start(CreateCodeDTO createCodeDTO) throws UserException {

        String[] aryType = createCodeDTO.getCodeName().split(",");
        for (String type : aryType) {
            String tableName = createCodeDTO.getTableName();
            String packageName = createCodeDTO.getPackageName();
            if (type.equals("Entity")) {

                try {
                    this.CreateEntityFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;
            if (type.equals("Controller")) {
                try {
                    this.CreateControllerFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;
            if (type.equals("Dao")) {

                try {
                    this.CreateDaoFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;
            if (type.equals("Service")) {
                try {
                    this.CreateServiceFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;

            if (type.equals("HtmlEdit")) {
                try {
                    this.CreateHtmlEditFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;
            if (type.equals("HtmlList")) {
                try {
                    this.CreateHtmlListFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;
            if (type.equals("HtmlDetail")) {
                try {
                    this.CreateHtmlDetailFile(tableName, packageName);
                } catch (IOException ioException) {
                    throw new UserException(ioException.getMessage());
                }

            }
            ;

        }

    }

    // 首字母小写
    private String lcFirst(String name) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);// UpperCase大写
        return name;

    }

    // 首字母大写写
    private String ucFirst(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);// UpperCase大写
        return name;

    }

    private String getRightClassName(String tableName) {

        String[] aryContent = tableName.split("_");
        String result = "";
        for (String s : aryContent) {
            result += this.ucFirst(s);
        }

        return this.ucFirst(result);
    }

    // 001 创建Controller类
    public String CreateControllerFile(String tableName, String packageName) throws IOException {

        String result = this.CreateTemplateFile(tableName, packageName, "ctrl_view.html", "Controller",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$PackageName#", packageName);
                    s = s.replaceAll("#\\$TableName#", tableName);
                    s = s.replaceAll("#\\$ClassName0#", ClassName0);
                    s = s.replaceAll("#\\$ClassName#", ClassName);
                    return s;

                });
        return result;

    }

    // 002 创建Dao类
    public String CreateDaoFile(String tableName, String packageName) throws IOException {

        String result = this.CreateTemplateFile(tableName, packageName, "dao_view.html", "Dao",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$PackageName#", packageName);
                    s = s.replaceAll("#\\$ClassName0#", ClassName0);
                    return s;

                });
        return result;

    }

    private String getClassSeterGetter(List<Map<String, Object>> lstField) {

        // "name": "id",
        // "comment": "",
        // "type": "int"
        StringBuilder sb = new StringBuilder();
        StringBuilder sbJson = new StringBuilder();
        for (Map<String, Object> map : lstField) {

            String fieldName0 = this.getRightClassName(map.get("name").toString());
            String fieldName = this.lcFirst(fieldName0);
            String comment = map.get("comment").toString();
            String typeName = map.get("type").equals("int") ? "int" : "String";

            sb.append("//@NotEmpty(message = \"" + comment + "\"" + ")\r\n");
            sb.append("/* " + comment + "*/\r\n");
            sb.append("private " + typeName + " " + fieldName + ";" + "\r\n");
            sb.append("public " + typeName + " get" + fieldName0 + "() {" + "\r\n");
            sb.append("    return " + fieldName + ";" + "\r\n");
            sb.append("}" + "\r\n");
            sb.append("public void set" + fieldName0 + "(" + typeName + " " + fieldName + ") {" + "\r\n");
            sb.append("    this." + fieldName + " = " + fieldName + ";" + "\r\n");
            sb.append("}" + "\r\n");

        }
        return sb.toString();

    }

    private String getClassJson(List<Map<String, Object>> lstField) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sbJson = new StringBuilder();
        for (Map<String, Object> map : lstField) {

            String fieldName0 = this.getRightClassName(map.get("name").toString());
            String fieldName = this.lcFirst(fieldName0);
            String comment = map.get("comment").toString();
            String typeName = map.get("type").equals("int") ? "int" : "String";
            sbJson.append("\"" + fieldName + "\":\"\",\r\n");

        }
        return sbJson.toString();

    }

    // 002 创建Entity类
    public String CreateEntityFile(String tableName, String packageName) throws IOException {

        List<Map<String, Object>> lstField = this.getTableDesc(tableName);
        String result = this.CreateTemplateFile(tableName, packageName, "entity_view.html", "",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$PackageName#", packageName);
                    s = s.replaceAll("#\\$ClassName0#", ClassName0);
                    s = s.replaceAll("#\\$ClassSetterGetter#", this.getClassSeterGetter(lstField));
                    s = s.replaceAll("#\\$ClassJson#", this.getClassJson(lstField));
                    return s;

                });
        return result;

    }

    // service_view
    private String getClassUpdateWrapper(List<Map<String, Object>> lstField) {

        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : lstField) {

            String fieldName0 = this.getRightClassName(map.get("name").toString());
            String fieldName = this.lcFirst(fieldName0);
            
            String comment = map.get("comment").toString();
            String typeName = map.get("type").equals("int") ? "int" : "String";

            if (!fieldName.equals("id") && !fieldName.equals("Id")
                && !fieldName.toLowerCase().equals("createtime")
              ) {// 如果是Id字段默认不生成更新列
                sb.append("   updateWrapper.set(\"" + fieldName + "\", u.get" + fieldName0 + "());\r\n");
            }

        }
        return sb.toString();

    }

    // 003 创建Service类
    public String CreateServiceFile(String tableName, String packageName) throws IOException {

        List<Map<String, Object>> lstField = this.getTableDesc(tableName);
        String result = this.CreateTemplateFile(tableName, packageName, "service_view.html", "Service",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$PackageName#", packageName);
                    s = s.replaceAll("#\\$ClassName0#", ClassName0);
                    s = s.replaceAll("#\\$ClassName#", ClassName);
                    s = s.replaceAll("#\\$ClassUpdateWrapper#", this.getClassUpdateWrapper(lstField));
                    return s;

                });
        return result;

    }

    private String getHtmlEdit(List<Map<String, Object>> lstField) {

        StringBuilder sb = new StringBuilder();
        int num = 0;
        sb.append("<div class=\"row clearfix\">\r\n");
        for (Map<String, Object> map : lstField) {

            String fieldName0 = this.getRightClassName(map.get("name").toString());
            String fieldName = this.lcFirst(fieldName0);
            String comment = map.get("comment").toString();
            String typeName = map.get("type").equals("int") ? "int" : "String";

            if (fieldName.toLowerCase().equals("id")
                    || fieldName.toLowerCase().equals("createtime")
                    || fieldName.toLowerCase().equals("updatetime")) {
                continue;
            }


            sb.append("<div class=\"col-lg-2 form-control-label\">\r\n");
            sb.append("     <label id=\"lb"+fieldName+"\" for=\"" + fieldName + "\">" + comment + "</label>\r\n");
            sb.append("</div>\r\n");
            sb.append("<div class=\"col-lg-4\">\r\n");
            sb.append("   <div class=\"form-group\">\r\n");
            sb.append("      <div class=\"form-line\">\r\n");
            sb.append("         <input type=\"text\" name=\"" + fieldName + "\" id=\"" + fieldName
                    + "\" class=\"form-control\" placeholder=\"请输入" + comment + "\">\r\n");
            sb.append("      </div>\r\n");
            sb.append("   </div>\r\n");
            sb.append("</div>\r\n");
            
            num = num + 1;

        }
        sb.append("</div>");
        return sb.toString();

    }

    // 004 创建html-edit片段
    public String CreateHtmlEditFile(String tableName, String packageName) throws IOException {

        List<Map<String, Object>> lstField = this.getTableDesc(tableName);
        String result = this.CreateTemplateFile(tableName, packageName, "html_edit_view.html", "_edit.html",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$TableName#", tableName); // $ClassName0
                    s = s.replaceAll("#\\$ClassName0#", ClassName0); // $ClassName0
                    s = s.replaceAll("#\\$ClassHtmlEdit#", this.getHtmlEdit(lstField));
                    return s;

                });
        return result;

    }

    // 004 创建html-edit片段
    public String CreateHtmlDetailFile(String tableName, String packageName) throws IOException {

        List<Map<String, Object>> lstField = this.getTableDesc(tableName);
        String result = this.CreateTemplateFile(tableName, packageName, "html_detail_view.html", "_detail.html",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$TableName#", tableName); // $ClassName0
                    s = s.replaceAll("#\\$ClassName0#", ClassName0); // $ClassName0
                    s = s.replaceAll("#\\$ClassHtmlEdit#", this.getHtmlEdit(lstField));
                    return s;

                });
        return result;

    }

    private String getHtmlOption(List<Map<String, Object>> lstField) {

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (Map<String, Object> map : lstField) {

            String fieldName0 = this.getRightClassName(map.get("name").toString());
            String fieldName = this.lcFirst(fieldName0);
            String comment = map.get("comment").toString();
            String typeName = map.get("type").equals("int") ? "int" : "String";

            if (fieldName.toLowerCase().equals("id")
                    || fieldName.toLowerCase().equals("createtime")
                    || fieldName.toLowerCase().equals("updatetime")) {
                continue;
            }
            comment = StrUtil.isNullOrEmpty(comment) ? "" : comment;
            sb.append("<option value=\"" + map.get("name").toString() + "\">" + comment + "</option>\r\n");
        }
        return sb.toString();

    }

    // 005 创建html-list片段
    public String CreateHtmlListFile(String tableName, String packageName) throws IOException {

        List<Map<String, Object>> lstField = this.getTableDesc(tableName);
        String result = this.CreateTemplateFile(tableName, packageName, "html_list_view.html", "_list.html",
                (s, ClassName0, ClassName) -> {
                    s = s.replaceAll("#\\$TableName#", tableName); // $ClassName0
                    s = s.replaceAll("#\\$ClassName0#", ClassName0); // $ClassName0
                    s = s.replaceAll("#\\$ClassName#", ClassName); // $ClassName0
                    s = s.replaceAll("#\\$ClassHtmlOption#", this.getHtmlOption(lstField));
                    return s;

                });
        return result;

    }

    // 根据模板创建文件
    private String CreateTemplateFile(String tableName, String packageName,
            String templateFileName,
            String createdFileName,
            CreateCodeInterface createCodeInterface) throws IOException {

        String TableName = this.lcFirst(tableName);
        String ClassName0 = this.getRightClassName(tableName);
        String ClassName = this.lcFirst(ClassName0);
        ClassPathResource classPathResource = new ClassPathResource("java_template/" + templateFileName);
        InputStream input = classPathResource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {

            s = createCodeInterface.getTemplateContent(s, ClassName0, ClassName);
            sb.append(s);
            sb.append("\r\n");

        }
        reader.close();
        input.close();
        String fileName = "";
        if (templateFileName.contains("html_") || templateFileName.contains("js_")) {
            fileName = tableName + createdFileName;
        } else {
            fileName = ClassName0 + createdFileName + ".java";
        }
        byte[] aryContent = sb.toString().getBytes(StandardCharsets.UTF_8);
        Files.write(Paths.get("./java_source/" + fileName), aryContent);
        return sb.toString();

    }

}
