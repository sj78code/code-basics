package threads.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class BlockProducerWhileConsumingTest {

    public static void main(String[] args) {
        Container c = new Container();
        Producer producer = new Producer(c);
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(producer::execute);

        ScheduledExecutorService scheduledService =  Executors.newScheduledThreadPool(1);
        SwiftBlockingConsumer consumers = new SwiftBlockingConsumer(c);
//        scheduledService.schedule(consumers::execute, 1, TimeUnit.SECONDS);
        scheduledService.scheduleWithFixedDelay(consumers::execute, 5, 15, TimeUnit.SECONDS);


    }

}
