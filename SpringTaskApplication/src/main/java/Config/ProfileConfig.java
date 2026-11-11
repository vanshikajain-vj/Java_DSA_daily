package Config;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ProfileConfig {

    private final Environment environment;

    public ProfileConfig(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void showProfile() {

        System.out.println("Active Profile: " +
                environment.getActiveProfiles()[0]);

        System.out.println("Database URL: " +
                environment.getProperty("spring.datasource.url"));
    }
}
