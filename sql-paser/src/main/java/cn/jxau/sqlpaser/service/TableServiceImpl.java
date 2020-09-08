package cn.jxau.sqlpaser.service;

import cn.jxau.common.pojo.Db;

import cn.jxau.common.pojo.QueryResult;

import cn.jxau.common.service.db.TableService;
import cn.jxau.sqlpaser.config.DataSourceManager;
import cn.jxau.sqlpaser.utils.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author l
 * @create 2020-08-31-22:29
 */
@org.apache.dubbo.config.annotation.Service
public class TableServiceImpl implements TableService {
    @Autowired
    private DataSourceManager dataSourceManager;
    @Autowired
    private Jdbc jdbcExcute;
    @Override
    public QueryResult getAllTables(Db db) {
        return jdbcExcute.getAllTables(dataSourceManager.getDataSource(db));
    }

    @Override
    public QueryResult getTableInfo(Db db) {
        return null;
    }
}
