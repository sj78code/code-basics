package threads.example3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockTest {

    public static void main(String[] args) {
        Worker w = new Worker();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        executorService1.submit(w::producer);
        executorService2.submit(w::consumer);

        executorService1.shutdown();
        executorService2.shutdown();

    }

}
