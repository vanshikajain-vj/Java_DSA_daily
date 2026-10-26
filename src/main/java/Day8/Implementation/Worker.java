package Day8.Implementation;

public class Worker extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Worker is running...");

                Thread.sleep(1000); // Pause for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Worker interrupted. Stopping gracefully...");
        }

        System.out.println("Worker terminated.");
    }
}