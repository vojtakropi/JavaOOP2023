package cz.cvut.test.model;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {

    private String name;

    private String info;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.toString().contains(name)){
            arg = arg.toString().replace(this.name,"");
            info = (String) arg;
            System.out.println(arg);
        }

    }

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }
}
