package du12.src.main.java;

public class Main {
    public static void main(String[] args) {

        HotdogShop shop = new HotdogShop();
        PersonH vojta = new PersonH("vojta");

        shop.buyHotdog(vojta, shop);
        System.out.println(shop.getState());

    }


}
