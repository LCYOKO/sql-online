package cn.jxau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author l
 * @create 2020-08-31-22:40
 */
@Data
@AllArgsConstructor
public class DbResopnse {
   private String msg;
   private int code;
   private Object data;
   private long time;
}
