package du3.src.main.java;

import javax.swing.text.html.parser.Parser;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("eneter numbers to sum, if you want to end and sum, type end");
        Calculator calculator = new Calculator();
        while (myObj.hasNext()){
            String number = myObj.nextLine();
            int num;
            if (number.equals("end")) break;
            try {
                num = Integer.parseInt(number);
                if (num < 0) {
                    System.out.println("zadej kladne cislo");
                    continue;
                }
                calculator.AddtoList(num);
            }
            catch(Exception e) {
                System.out.println("zadej cislo a ne pismena");
            }
        }
        calculator.Calculate();
        calculator.DeleteEntries();
    }

    private String concat(String a, String b){
        return a + " " + b;
    }

    private int sumStrings(String a, String b){
        return Integer.parseInt(a) + Integer.parseInt(b);
    }
}
