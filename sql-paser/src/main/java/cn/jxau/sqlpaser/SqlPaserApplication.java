package cn.jxau.sqlpaser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SqlPaserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlPaserApplication.class, args);
    }

}
