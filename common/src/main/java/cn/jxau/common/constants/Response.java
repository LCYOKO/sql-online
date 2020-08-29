package cn.jxau.common.constants;

import lombok.Builder;
import lombok.Data;

/**
 * @author l
 * @create 2020-08-29-22:13
 */
@Data
@Builder
public class Response {
    private Integer code;
    private String msg;
    private Object data;
}
