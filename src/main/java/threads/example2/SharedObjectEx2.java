package threads.example2;

public class SharedObjectEx2 {

    public void display() {

        synchronized (this) {

            System.out.println("I am inside ...");
            try {
                this.notify();
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
