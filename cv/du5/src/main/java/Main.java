package du5.src.main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Nemoc> a = new ArrayList<>();
        a.add(new Nemoc("cholera", 6));
        a.add(new Nemoc("rakovina", 10));

        Pacient pacient1 = new Pacient("petr", "durak", LocalDate.of(2000, 9, 11), 188, 80,2002000202, a);
        System.out.println(pacient1);
    }
}
