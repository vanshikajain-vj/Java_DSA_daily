package Day2.Implementation_Notification_Channel;

public class Main {

    public static void main(String[] args) {

        NotificationService service = new NotificationService();

        service.sendNotification(new SmsChannel(), "Hello!");
        service.sendNotification(new EmailChannel(), "Welcome!");
        service.sendNotification(new PushChannel(), "New update!");
    }
}