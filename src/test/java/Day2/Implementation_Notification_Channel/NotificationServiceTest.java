package Day2.Implementation_Notification_Channel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationServiceTest {

    @Test
    void sendsMessageThroughNotificationChannel() {
        String message = "Welcome!";
        NotificationChannel channel = sentMessage -> assertEquals(message, sentMessage);
        NotificationService service = new NotificationService();

        service.sendNotification(channel, message);
    }
}
