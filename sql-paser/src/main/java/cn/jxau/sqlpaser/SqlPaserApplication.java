package cn.jxau.sqlpaser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SqlPaserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlPaserApplication.class, args);
    }

}
