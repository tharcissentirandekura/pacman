import java.util.ArrayList;
import java.util.Iterator;

public class UsingIterators {



    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<Integer>(100);

        for (int i = 0; i < 100; i++){
            al.add(i);
        }

        // Iterator<Integer> iter = al.iterator();
        // while (iter.hasNext()) {
        //     int obj = iter.next();
        //     // Do something with obj
        //     System.out.println(obj);

        //     if (obj % 2 == 0){
        //         System.out.println("The numbe is even :" + obj);
        //     }
        // }

        // for ( int obj : al){
        //     System.out.println(obj);

        // }

        Iterator<Integer> iter = al.iterator();

        while (iter.hasNext()) {
            int obj = iter.next();
            // Do something with obj.
            System.out.println(obj);
        }

    }
    
}
