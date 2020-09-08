package cn.jxau.sqlpaser.utils;

import cn.jxau.common.constants.BaseSql;
import cn.jxau.common.constants.JdbcError;
import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;
import cn.jxau.common.pojo.QueryResult;
import cn.jxau.sqlpaser.config.DataSourceManager;
import com.alibaba.druid.util.JdbcUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author l
 * @create 2020-08-31-9:03
 */
@Component
public class Jdbc {

    private static final String SHOW_COLUMNS_TABLE = "select `table_name` as tableName, `column_key` as columnKey, " +
            "`column_name` as columnName, `column_type` as columnType, " +
            "`column_comment` as columnComment, `column_default` as columnDefault, `is_nullable` as isNullable " +
            "from information_schema.columns where `table_schema` = '%s' and `table_name` in ( '%s' );";

   private final String TABLE_NAME="TABLE_NAME";



    public QueryResult getAllTables(DataSource dataSource){
          return executeSql(dataSource, BaseSql.SHOW_TABLES);
     }

     public QueryResult getShowTablesInfo(DataSource dataSource){
          return executeSql(dataSource,BaseSql.SHOW_CREATE_TABLES);
     }
    private QueryResult executeSql(DataSource dataSource, String sql) {
        try {
            long startTime = System.currentTimeMillis();
            List<Map<String, Object>> result = JdbcUtils.executeQuery(dataSource, sql);

            LinkedList<String> metaData = new LinkedList();
            if(BaseSql.SHOW_TABLES.equals(sql)){
                ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                HashMap<String, Object> map;
                for(int i=0;i<result.size();i++){
                     map = new HashMap<>();
                    map.put(TABLE_NAME,result.get(i).values());
                   list.add(map);
                }
                result=list;
               //System.out.println(result);
            }
            else if (!CollectionUtils.isEmpty(result)) {
                Map<String, Object> map = result.get(0);
                map.forEach((key, value) -> metaData.addLast(key));
            }

            long endTime = System.currentTimeMillis()-startTime;
            return new QueryResult("成功",endTime,200,result,metaData);
        } catch (Exception e) {

            return new QueryResult(e.getMessage(),0L,JdbcError.QUERY_FAILURE_CODE,null,null);
        }
    }
}
