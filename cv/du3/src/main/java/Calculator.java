package du3.src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public ArrayList<Integer> numbers= new ArrayList<>();


    public void AddtoList(Integer a){
        numbers.add(a);
    }

    public void DeleteEntries(){
        numbers.clear();
    }

    public void Calculate(){
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

}
