package cn.jxau.web.controller.db;

import cn.jxau.common.constants.Common;
import cn.jxau.common.constants.Response;
import cn.jxau.common.pojo.QueryResult;
import cn.jxau.common.service.db.TableService;
import cn.jxau.web.service.DbService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author l
 * @create 2020-09-08-16:39
 */
@RestController
@RequestMapping("/web/table")
public class TableController {
   @Reference
    private TableService tableService;
   @Autowired
    private DbService dbService;
   @GetMapping("/getAllTables")
   public Response getAllTables(Integer id){
       if(id==0) return new Response(Common.SUCCESS_CODE,Common.SUCCESS_MSG,new ArrayList<>());
       QueryResult tables = tableService.getAllTables(dbService.selById(id));
       if(tables.getCode()!=200) return new Response(Common.FAIL_CODE,tables.getMsg(),null );
       return new Response(Common.SUCCESS_CODE,Common.SUCCESS_MSG,tables);
   }
}
