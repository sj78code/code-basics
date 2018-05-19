package threads.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExample1 {

    public static void main(String[] args) {
        SharedObject o1 = new SharedObject();
        SharedObject o2 = new SharedObject();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.submit(o1::display);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.submit(o2::display);
        executorService1.shutdown();
        executorService2.shutdown();
    }

}
