package health;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PaymentHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        boolean paymentWorking = true;

        if (paymentWorking) {
            return Health.up()
                    .withDetail("Payment Gateway", "Working")
                    .build();
        }

        return Health.down()
                .withDetail("Payment Gateway", "Not Working")
                .build();
    }
}

