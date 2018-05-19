package threads.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SwiftBlockingConsumer {


    private Container container;
    public SwiftBlockingConsumer(Container container){
        this.container = container;
    }

    public void execute(){
        System.out.println("Inside Consumer ...");
        container.backup();

    }



}
