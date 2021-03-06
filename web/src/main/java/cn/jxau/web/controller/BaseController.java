package cn.jxau.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author l
 * @create 2020-08-29-22:37
 */
@Controller
public class BaseController {
     @GetMapping("/")
     public String doIndex(){
         return "index.html";
     }
     @GetMapping("/index")
     public String doIndex2(){
         return "index";
     }

     @GetMapping("/toPage")
    public String getPage(String method){
         if(StringUtils.isBlank(method)) return "error/404";
         return method;
     }
}
