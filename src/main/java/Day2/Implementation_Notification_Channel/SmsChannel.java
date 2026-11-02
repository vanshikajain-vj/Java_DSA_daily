package Day2.Implementation_Notification_Channel;

public class SmsChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
