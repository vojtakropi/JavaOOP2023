package du8.src.main.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>(){{
            add("petr");
            add("dan");
            add("adam");
        }};
        System.out.println(set);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);


        Calculator1 calculator1 = new Calculator1();
        System.out.println(calculator1.sum(1,2));
        Calculator2 calculator2 = new Calculator2();
        System.out.println(calculator2.sum(1,2));
    }
}
