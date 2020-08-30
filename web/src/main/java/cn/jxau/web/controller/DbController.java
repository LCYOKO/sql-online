package cn.jxau.web.controller;



import cn.jxau.common.constants.Common;
import cn.jxau.common.constants.Response;
import cn.jxau.web.entity.Db;
import cn.jxau.web.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcy
 * @since 2020-08-30
 */
@RestController
@RequestMapping("/web/db")
public class DbController {
    @Autowired
    private DbService dbService;
    @GetMapping("/getAll")
    public Response getAll(@RequestParam(name ="page",defaultValue ="1") Integer page, @RequestParam(name = "limit",defaultValue ="10") Integer limit){
        return new Response(Common.SUCCESS_CODE,Common.SUCCESS_MSG,dbService.selAll(page,limit));
    }

    @PostMapping("/add")
    public Response addDb(Db db){
         int cnt=dbService.addDb(db);
         if(cnt==0) return new Response(Common.FAIL_CODE,Common.FAIL_MSG,"");
         return new Response(Common.SUCCESS_CODE,Common.SUCCESS_MSG,"");
    }

    @GetMapping("/getAllList")
    public Response getAllList(){
          return  new Response(Common.SUCCESS_CODE,Common.SUCCESS_MSG,dbService.selAllVo());
    }

}

