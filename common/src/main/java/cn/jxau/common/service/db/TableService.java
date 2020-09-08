package cn.jxau.common.service.db;

import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;
import cn.jxau.common.pojo.QueryResult;

import java.util.List;

/**
 * @author l
 * @create 2020-08-30-21:10
 */
public interface TableService {
    QueryResult getAllTables(Db db);
    QueryResult getTableInfo(Db db);
}
