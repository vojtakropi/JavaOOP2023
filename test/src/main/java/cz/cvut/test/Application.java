package cz.cvut.test;

import java.util.Random;

public class Application {



    public String random4Digits() {
        return String.format("%04d", new Random().nextInt(10000));
    }
}
