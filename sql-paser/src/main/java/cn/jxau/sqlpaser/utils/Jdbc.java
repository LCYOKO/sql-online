package cn.jxau.sqlpaser.utils;

import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;
import cn.jxau.sqlpaser.config.DataSourceManager;
import com.alibaba.druid.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * @author l
 * @create 2020-08-31-9:03
 */
@Component
public class Jdbc {
    private static final String SHOW_TABLES = "show tables";
    private static final String SHOW_COLUMNS_TABLE = "select `table_name` as tableName, `column_key` as columnKey, " +
            "`column_name` as columnName, `column_type` as columnType, " +
            "`column_comment` as columnComment, `column_default` as columnDefault, `is_nullable` as isNullable " +
            "from information_schema.columns where `table_schema` = '%s' and `table_name` in ( '%s' );";
    private static final String SHOW_TABLE_FIELD = "Tables_in_%s";


    @Autowired
    private DataSourceManager dataSourceManager;


//    public List<String> allColumnInTable(String schema, String table) {
//        Map<String, DataSource> dataSourceMap = dataSourceManager.getDataSourceMap();
//        DataSource dataSource = dataSourceMap.get(schema);
//        JdbcResultResp result = executeSql(dataSource, String.format(SHOW_COLUMNS_TABLE, schema, table));
//        if (Objects.equals(result.getQueryStatus(), SUCCESS)) {
//            return result.getResult()
//                    .stream()
//                    .map(map -> (String) map.get("columnName"))
//                    .collect(toList());
//        }
//        throw new BektzServerException(QUERY_FAILURE_CODE, QUERY_FAILURE_MESSAGE);
//    }
//
//    public List<String> allTablesInSchema(String schema) {
//        Map<String, DataSource> dataSourceMap = dataSourceManager.getDataSourceMap();
//        DataSource dataSource = dataSourceMap.get(schema);
//        JdbcResultResp result = executeSql(dataSource, SHOW_TABLES);
//        if (Objects.equals(result.getQueryStatus(), SUCCESS)) {
//            return result.getResult()
//                    .stream()
//                    .map(map -> (String) map.get(String.format(SHOW_TABLE_FIELD, schema)))
//                    .collect(toList());
//        }
//        throw new BektzServerException(QUERY_FAILURE_CODE, QUERY_FAILURE_MESSAGE);
//    }


    public DbResopnse executeSql(DataSource dataSource, String sql) {
        try {
            long startTime = System.currentTimeMillis();
            List<Map<String, Object>> result = JdbcUtils.executeQuery(dataSource, sql);
            System.out.println(result);
            LinkedList metaData = new LinkedList();
            if (!CollectionUtils.isEmpty(result)) {
                Map<String, Object> map = result.get(0);
                map.forEach((key, value) -> metaData.addLast(key));

            }
            long endTime = System.currentTimeMillis()-startTime;
            return new DbResopnse("成功",200,metaData,endTime);
        } catch (Exception e) {
            //log.error("执行sql失败 sql:{}", sql, e);
            return new DbResopnse("失败",400,null,0);}
    }
}
