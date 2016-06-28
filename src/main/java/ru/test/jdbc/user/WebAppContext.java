package ru.test.jdbc.user;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ru.test.jdbc.user")
public class WebAppContext extends WebMvcConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource  dataSource = new DriverManagerDataSource();
        try{
            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
            dataSource.setUrl(props.getProperty("jdbc.url"));
            dataSource.setUsername(props.getProperty("jdbc.username"));
            dataSource.setPassword(props.getProperty("jdbc.password"));
        }
        catch (IOException e){
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/dbtest");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
        }

        return dataSource;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
