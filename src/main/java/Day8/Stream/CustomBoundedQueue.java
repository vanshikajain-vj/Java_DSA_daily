package Day8.Stream;
import java.util.LinkedList;
import java.util.Queue;

public class CustomBoundedQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public CustomBoundedQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }

        queue.add(item);
        System.out.println("Produced: " + item);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if queue is empty
        }

        T item = queue.remove();
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}
