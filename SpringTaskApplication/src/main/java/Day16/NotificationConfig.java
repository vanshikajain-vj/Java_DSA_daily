package Day16;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    @ConditionalOnProperty(
            name = "notification.enabled",
            havingValue = "true"
    )
    public EmailService emailService() {
        System.out.println("EmailService Bean Created!");
        return new EmailService();
    }
}
