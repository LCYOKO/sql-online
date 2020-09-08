package cn.jxau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author l
 * @create 2020-09-02-8:59
 */
@Data
@AllArgsConstructor
public class QueryResult implements Serializable {
   private String msg;
   private Long times;
   private Integer code;
   private List<Map<String,Object>> data;
   private List<String> metaData;

}
