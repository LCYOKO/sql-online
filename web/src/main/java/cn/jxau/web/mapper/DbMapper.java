package cn.jxau.web.mapper;

import cn.jxau.common.pojo.Db;

import cn.jxau.web.entity.DbVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcy
 * @since 2020-08-30
 */
public interface DbMapper extends BaseMapper<Db> {
        @Select("select id,source,status from db where status=1")
        List<DbVO> selAll();
}
