package du2.src.main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 4;
        int y = 5;
        int z = x+y;
        System.out.println(z);

        String txt = "2";
        int number = 2;
        System.out.println(txt + number);



        System.out.println("aplikace spustena");
        Scanner scanner = new Scanner(System.in);
        System.out.println("zadej prvni cislo na secteni");
        int a = scanner.nextInt();
        System.out.println("zadej druhe cislo");
        int b = scanner.nextInt();
        int vysledek = Soucet(a, b);
        System.out.println("Vysledek:" + vysledek);
    }

    private static int Soucet(int a, int b){
        return a+b;
    }

}
