package threads.example3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {

    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();
    public void producer() {
        lock.lock();

        System.out.println("Inside Producer... Sleeping");
        try {
            Thread.sleep(5000);
            condition.await();
            System.out.println("Inside Producer again..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
//            lock.unlock();
        }
        lock.unlock();
        System.out.println("Producer exiting...");
    }

    public void consumer() {
        lock.lock();
        System.out.println("Inside Consumer...");
        try {
            Thread.sleep(2000);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("Consumer exiting...");
    }
}
