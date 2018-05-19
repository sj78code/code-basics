package threads.example1;

public class SharedObject {


    public void display() {
        synchronized (SharedObject.class) {

            System.out.println("I am inside ...");
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
