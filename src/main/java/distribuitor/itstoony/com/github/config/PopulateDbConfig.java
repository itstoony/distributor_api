package distribuitor.itstoony.com.github.config;

import distribuitor.itstoony.com.github.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopulateDbConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean populateDatabase() {
        if (!"create-drop".equals(strategy)) {
            return false;
        }

        dbService.populateDatabase();

        return true;

    }

}
