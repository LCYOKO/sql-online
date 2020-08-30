package cn.jxau.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author l
 * @create 2020-08-30-16:27
 */
@Data
public class DbVO {
  private Integer id;
  @TableField(value = "source")
  private String  source;
  private Integer status;
}
