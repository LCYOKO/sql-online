package cn.jxau.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcy
 * @since 2020-08-30
 */
@Data
public class Db implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String url;

    private Integer port;

    private String source;

    private String username;

    private String password;

    private Integer status;

    private Date updateTime;

    private String info;


}
