package cn.jxau.web.controller;

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
}
