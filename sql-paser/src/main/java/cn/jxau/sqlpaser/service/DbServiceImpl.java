package cn.jxau.sqlpaser.service;

import cn.jxau.common.pojo.Db;
import cn.jxau.common.pojo.DbResopnse;
import cn.jxau.common.service.db.DbService;
import cn.jxau.sqlpaser.config.DataSourceManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @create 2020-08-31-22:29
 */
@Service
public class DbServiceImpl implements DbService {
    @Autowired
    private DataSourceManager dataSourceManager;
    @Override
    public DbResopnse getAllTables(Db db) {


        return null;
    }
}
