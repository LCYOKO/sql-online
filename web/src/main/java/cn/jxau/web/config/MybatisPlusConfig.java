package cn.jxau.web.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author l
 * @create 2020-08-30-16:14
 */
@Configuration
@MapperScan("cn.jxau.web.mapper")
public class MybatisPlusConfig {
   @Bean
   public PaginationInterceptor paginationInterceptor(){
       return  new PaginationInterceptor();
   }
}
