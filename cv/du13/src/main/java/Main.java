package du13.src.main.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){

        Iterate();
        Skate();

    }

    private static void Skate(){
        Skates skates = new BauerSkates(new BasicSkates());
        skates.skating();
    }

    private static void Iterate(){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++)
            list.add(i);


        System.out.println(list);


        Iterator<Integer> itr = list.iterator();


        while (itr.hasNext()) {
            int i = itr.next();

            if (i % 2 == 0)
                itr.remove();
        }

        System.out.println(list);
    }


}
