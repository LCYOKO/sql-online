package cn.jxau.sqlpaser.config;

import cn.jxau.common.pojo.Db;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author l
 * @create 2020-08-30-21:19
 */
@Component
public class DataSourceManager {
    private static final String MYSQL_CONNECTION_URL_TEMPLATE = "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private ConcurrentHashMap<String, DataSource> dataSourceMap = new ConcurrentHashMap();

    private synchronized void  init(Db db){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword(db.getPassword());
        dataSource.setUsername(db.getUsername());
        dataSource.setUrl(String.format(MYSQL_CONNECTION_URL_TEMPLATE,db.getUrl(),db.getPort(),db.getSource()));
        dataSource.setMaxActive(3);
        dataSource.setRemoveAbandoned(true);
        dataSource.setTestOnBorrow(true);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setQueryTimeout(10);
        try (Connection ignored = dataSource.getConnection(10000)) {
            dataSourceMap.put(db.getSource(), dataSource);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException( "添加数据库失败");
        }
    }

    public DataSource getDataSource(Db db){
        if(dataSourceMap.get(db.getSource())==null) init(db);
         return  dataSourceMap.get(db.getSource());
    }
}
