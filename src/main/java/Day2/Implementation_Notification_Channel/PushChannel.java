package Day2.Implementation_Notification_Channel;

public class PushChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Push: " + message);
    }
}
