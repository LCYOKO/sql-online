package cn.jxau.sqlpaser;

import cn.jxau.common.constants.BaseSql;
import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;
import cn.jxau.common.pojo.QueryResult;
import cn.jxau.sqlpaser.config.DataSourceManager;
import cn.jxau.sqlpaser.utils.Jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlPaserApplicationTests {
   @Autowired
   private Jdbc jdbcTemplate;
   @Autowired
   private DataSourceManager dataSourceManager;
    @Test
    void contextLoads() {
//        Db db = new Db();
//        db.setPassword("3852159");
//        db.setPort(3306);
//        db.setUsername("root");
//        db.setUrl("127.0.0.1");
//        db.setSource("dc");
//        QueryResult tables = jdbcTemplate.executeSql(dataSourceManager.getDataSource(db),
//                String.format(BaseSql.SHOW_CREATE_TABLES,"admin"));
//        System.out.println(tables);
    }

    @Test
     public  void test(){
         int a=1999*40+1199*70+2199*40;
         System.out.println(a);
     }
}
