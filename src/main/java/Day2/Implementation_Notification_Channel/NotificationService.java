package Day2.Implementation_Notification_Channel;

public class NotificationService {

    public void sendNotification(
            NotificationChannel channel, String message) {

        channel.send(message);
    }
}
