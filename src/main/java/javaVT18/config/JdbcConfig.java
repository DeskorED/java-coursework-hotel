package javavt18.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public CategoryDAO getCategoryJdbcDAO() {
        return new CategoryDAOJdbcImpl(dataSource);
    }
    @Bean
    public RoomDAO getRoomJdbcDAO() {
        return new RoomDAOJdbcImpl(dataSource);
    }
}