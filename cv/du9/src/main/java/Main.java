package du9.src.main.java;

public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        Singleton c = Singleton.getInstance();

        if(a==b && b==c){
            System.out.println("its singleton");
            System.out.println(a.hashCode());
            System.out.println(b.hashCode());
            System.out.println(c.hashCode());
        }
    }
}
