package cn.jxau.sqlpaser;

import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;
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
        Db db = new Db();
        db.setPassword("3852159");
        db.setPort(3306);
        db.setUsername("root");
        db.setUrl("127.0.0.1");
        db.setSource("dc");
        DbResopnse tables = jdbcTemplate.executeSql(dataSourceManager.getDataSource(db), "show tables");
        System.out.println(tables);
    }

}
