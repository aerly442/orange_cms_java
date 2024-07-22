package com.gfrjxz.cms.filter;


import com.gfrjxz.cms.entity.Manager;
import com.gfrjxz.cms.service.ManagerService;
import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.logging.Logger;


import org.slf4j.LoggerFactory;
import com.gfrjxz.cms.util.*;
import com.gfrjxz.cms.config.*;
import org.springframework.web.util.HtmlUtils;

@Component
@Order(1)
@WebFilter(urlPatterns = "*", filterName = "tokenFilter")
public class TokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Autowired
    private ManagerService managerService;

    /*检测用户的token*/
    private boolean checkUserToken(String token){

        if (token == null || token.equals("")){
            return false ;
        }
        try {
            String id     = EncryptUtil.DESdecode(token);
            int    userId = Integer.parseInt(id);
            Manager user  = managerService.getSinger(userId);
            return user!=null && user.getId() > 0;
        }
        catch (Exception ex){
            return false;
        }


    }

    private boolean allow(String url) {

         
        if (    url.contains("/hello/")
                || url.equals("/manager/login")
                || url.contains("/test/")



        ) {
            return true;
        }


        if (url.indexOf(".html") > 0 || url.indexOf(".js") > 0 || url.indexOf(".jpg") > 0 || url.indexOf(".gif") > 0
                || url.indexOf(".png") > 0 || url.indexOf(".css") > 0 || url.indexOf(".ico") > 0
                || url.indexOf(".woff") > 0 || url.indexOf(".ttf") > 0) {
            return true;
        }

        return false;
         
    }
   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
           throws IOException, ServletException{

       HttpServletRequest req = (HttpServletRequest) servletRequest;
       HttpServletResponse response = (HttpServletResponse) servletResponse;

       String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

      // if (req.getMethod().equals("OPTIONS")) {
      //     filterChain.doFilter(servletRequest, response);
     //     return;
      // }

       boolean allowedPath = allow(path);
       if (allowedPath == false) {

           //allowCrossAccess(req,response);

           String token = req.getHeader(Consts.TOKEN_NAME);// header方式
           token = token == null ? ((HttpServletRequest) servletRequest).getParameter(Consts.TOKEN_NAME) : token;

           response.setContentType("application/json;charset=UTF-8");
           if (StrUtil.isNullOrEmpty(token)) {
               response.getWriter().println(TokenFail.NOTOKENHEADER);
               return;
           }

           if (this.checkUserToken(token) == false){

               response.getWriter().println(TokenFail.TOKENISILLEGAL);
               return;
           }
           else{
               response.setHeader(Consts.TOKEN_NAME,token);
           }



       }
       // 执行
       filterChain.doFilter(servletRequest, response);

   }


    @Override
    public void destroy() {
    }

    /*
    protected void allowCrossAccess(HttpServletRequest request,HttpServletResponse response) {

        String allowOrigin = "*";
//		String allowOrigin = request.getHeader("Origin");
        String allowMethods = "GET,PUT,OPTIONS,POST,DELETE";
        String allowHeaders = "authorization,Origin,No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified,Cache-Control, Expires, Content-Type, X-E4M-With";

        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers", allowHeaders);
        response.addHeader("Access-Control-Allow-Methods", allowMethods);
        response.addHeader("Access-Control-Allow-Origin", allowOrigin);
        response.addHeader("Access-Control-Max-Age", "1800");//30 min
    }
    */

}
