package Day12;

public class Main {
    sealed interface PaymentEvent
            permits CreditCard, BankTransfer, Crypto {
    }

    record CreditCard(double amount, String cardNumber)
            implements PaymentEvent {
    }

    record BankTransfer(double amount, String bankName)
            implements PaymentEvent {
    }

    record Crypto(double amount, String currency)
            implements PaymentEvent {
    }

    public static String processPayment(PaymentEvent event) {

        return switch (event) {
            case CreditCard c ->
                    "Credit Card payment: " + c.amount();

            case BankTransfer b ->
                    "Bank Transfer payment: " + b.amount();

            case Crypto cr ->
                    "Crypto payment: " + cr.amount();
        };
    }

    public static void main(String[] args) {

        PaymentEvent p1 = new CreditCard(1000, "1234");
        PaymentEvent p2 = new BankTransfer(2000, "SBI");
        PaymentEvent p3 = new Crypto(3000, "Bitcoin");

        String json = """
        {
            "name": "Vanshika",
            "amount": 1000,
            "paymentType": "CreditCard"
        }
        """;

        System.out.println(processPayment(p1));
        System.out.println(processPayment(p2));
        System.out.println(processPayment(p3));
        System.out.println(json);
    }
}

