package cz.cvut.test.model;

import java.security.Key;
import java.util.*;

public class StorageSpace {

    public HashMap<Integer, Package> getUloziste() {
        return uloziste;
    }

    public void setUloziste(HashMap<Integer, Package> uloziste) {
        this.uloziste = uloziste;
    }

    private HashMap<Integer, Package> uloziste;

    public StorageSpace(HashMap<Integer, Package> uloziste) {
        this.uloziste = uloziste;
    }

    public int FreeSpace() throws Exception {
        for (Map.Entry<Integer, Package> set :
                uloziste.entrySet()) {
            if (set.getValue() == null) {
                System.out.println("nasel jsem volne misto");
                return set.getKey();
            }

        }
        throw new Exception("No free space in box");
    }
}
