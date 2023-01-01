package du12.src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Hotdog extends Observable {
    public String getState() {
        return state;
    }

    private String state;

    public Hotdog(PersonH personH) {
        this.state = "making it for " + personH.getName();
    }

    public void setNews(String news) {
        this.state = news;
        setChanged();
        notifyObservers(state);
    }


}
