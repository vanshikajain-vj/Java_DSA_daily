package Day8.Implementation;

public class SharedBuffer {
    private int value;
    private boolean available = false;

    public synchronized void produce(int number) throws InterruptedException {
        while (available) {
            wait();
        }

        value = number;
        available = true;

        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + value);
        available = false;

        notify();
    }
}