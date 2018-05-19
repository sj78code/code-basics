package threads.example2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExample2 {

    public static void main(String[] args) {
        SharedObjectEx2 obj = new SharedObjectEx2();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.submit(obj::display);
        executorService1.shutdown();
    }
}
