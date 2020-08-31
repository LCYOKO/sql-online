package cn.jxau.web.service;


import cn.jxau.common.pojo.Db;
import cn.jxau.web.entity.DbVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.javafx.collections.MappingChange;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcy
 * @since 2020-08-30
 */
public interface DbService extends IService<Db> {

   Map<String,Object> selAll(int page, int size);
   List<DbVO> selAllVo();
    Db selById(Integer id);
    int addDb(Db db);

}
