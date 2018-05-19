package threads.threadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Resource{

    Resource resource;
    public Resource(){

    }

    public void setResource(Resource resource){
        this.resource = resource;
    }



    public synchronized void display(String name){
        System.out.println("Used by " + name + " ");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Used by " + name + " Exception...");

            e.printStackTrace();
        }
        resource.display(name);
        System.out.println("Used by " + name + " releasing");
    }



    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();
        resource1.setResource(resource2);
        resource2.setResource(resource1);
        ExecutorService tp = Executors.newCachedThreadPool();
        tp.submit(() -> resource1.display("Number1"));
        tp.submit(() -> resource2.display("Number2"));
        tp.shutdown();
    }
}
