package cn.jxau.common.service.db;

import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;

import java.util.List;

/**
 * @author l
 * @create 2020-08-30-21:10
 */
public interface DbService {
    DbResopnse getAllTables(Db db);
}
