package du6.src.main.java;

import java.util.Arrays;
import java.util.List;

public class Application {
    public Application() {
        Porovnej();
        testToString();
    }

    public void Porovnej(){
        int a = 8000;
        int b = 8000;
        Integer c = 8000;
        Integer d = 8000;
        if(a == b && c.equals(d)){
            System.out.println("its equal");
        }
    }

    private void testToString(){
        List<Nemoc> nemoci = Arrays.asList(new Nemoc("cholera", 4), new Nemoc("revma", 100));
        Pacient vojta = new Pacient(nemoci, "vojta", 22);
        Pacient vojta2 = new Pacient(nemoci, "vojta", 22);
        System.out.println(vojta.toString());
        System.out.println(vojta.equals(vojta2));

    }


}
