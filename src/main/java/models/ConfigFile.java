package models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

@Configuration
public class ConfigFile {
    @Bean
    public DriverManagerDataSource mydataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/demo");
        ds.setUsername("root");
        ds.setPassword("root");

        return ds;
    }
    @Bean
    public JdbcTemplate myjdbctemp(){
        JdbcTemplate jd = new JdbcTemplate();
        jd.setDataSource(mydataSource());
        return  jd;
    }

}
