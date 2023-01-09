package du11.src.main.java;

public class Main {
    public static void main(String[] args) {
        Person vojta = new Person();
        vojta.setName("vojta").setAge(34).setAnimal("kocka");
        System.out.println(vojta);

        SauceFactory sauceFactory = new SauceFactory();
        Sauces sauce = sauceFactory.chooseSauce("sweet");
        sauce.putSauce();

    }
}
