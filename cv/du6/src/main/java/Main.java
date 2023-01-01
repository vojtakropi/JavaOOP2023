package du6.src.main.java;

public class Main {
    public static void main(String[] args) {

        Auto a = new Auto("a", 1, "a", new Motor("a", 4.0));
        System.out.println(a);
    }


    private Auto createSUV(String znacka, String barva, Integer rokVyroby){
        return new Auto(znacka,rokVyroby,barva,new Motor("benzin", 3.0));
    }
}
