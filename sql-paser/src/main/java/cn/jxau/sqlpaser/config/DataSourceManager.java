package cn.jxau.sqlpaser.config;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author l
 * @create 2020-08-30-21:19
 */
@Component
public class DataSourceManager {
    private static final String MYSQL_CONNECTION_URL_TEMPLATE = "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private ConcurrentHashMap<String, DataSource> dataSourceMap = new ConcurrentHashMap();

    private void init(){

    }

    public DataSource getDataSource(){

    }
}
