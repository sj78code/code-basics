package threads.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer {

    private Container container;
    public Producer(Container container){
        this.container = container;

    }


    public void execute(){

        for(int i = 1; i < 101; i++){
           container.add(String.valueOf(i));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
