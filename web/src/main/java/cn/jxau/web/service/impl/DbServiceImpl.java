package cn.jxau.web.service.impl;


import cn.jxau.common.pojo.Db;
import cn.jxau.web.entity.DbVO;
import cn.jxau.web.mapper.DbMapper;
import cn.jxau.web.service.DbService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcy
 * @since 2020-08-30
 */
@Service
public class DbServiceImpl extends ServiceImpl<DbMapper, Db> implements DbService {

    @Override
    public Map<String,Object> selAll(int page,int size) {
        IPage<Db> all = this.getBaseMapper().selectPage(new Page<>(page, size),null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",all.getTotal());
        map.put("item",all.getRecords());
        return map;
    }

    @Override
    public List<DbVO> selAllVo() {
        return this.baseMapper.selAll();
    }

    @Override
    public Db selById(Integer id) {
        return this.getById(id);
    }

    @Override
    public int addDb(Db db) {
        int insert = this.baseMapper.insert(db);
        return insert;
    }
}
