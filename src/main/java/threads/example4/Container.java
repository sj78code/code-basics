package threads.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Container {

    private List<String> list = new ArrayList<>();
    Object o1 = new Object();

    public void add(String s){
        synchronized (list) {
            list.add(s);
        }

        System.out.println("Prodcer added " + s + " via " + this);
    }

    public void backup(){
        List<String> backup = new ArrayList<>();
        synchronized (list){
            System.out.println("Lock " + " " + this);
            backup.addAll(list);
            System.out.println("Lock Exit" + list);
            list.clear();
            dbOperation( backup);
        }


    }

    private void dbOperation(List<String> s) {
        try {
            System.out.println("db Operation start " + s);
            Thread.sleep(10000);
            System.out.println("db Operation end " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
