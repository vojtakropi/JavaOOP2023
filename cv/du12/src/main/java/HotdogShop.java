package du12.src.main.java;

import java.util.*;

public class HotdogShop implements Observer {

    private String state;
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
}


    public void buyHotdog(PersonH personH, HotdogShop hotdogShop){
        Hotdog h = new Hotdog(personH);
        h.addObserver(hotdogShop);
        h.setNews(h.getState());
        System.out.println(state);
        h.setNews("done");
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setState((String) arg);
    }
}
