package cz.cvut.test.model;

import cz.cvut.test.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;

public class CvutBox extends Observable {

    StorageSpace storageSpace;

    private String name;

    private int pickPackageId;

    private String code;

    public CvutBox(String name) {

        this.storageSpace = new StorageSpace(new HashMap<Integer, Package>(){{
            put(1,null);put(2,null);put(3,null);put(4,null);
            put(5,null);put(6,null);put(7,null);put(8,null);
            put(9,null);put(10,null);put(11,null);put(12,null);
            put(13,null);put(14,null);put(15,null);put(16,null);
            put(17,null);put(18,null);put(19,null);put(20,null);}});
        this.name = name;

    }

    public void insertPackage(Package p) throws Exception {
        int freeSpace = storageSpace.FreeSpace();
        HashMap<Integer, Package> storage= storageSpace.getUloziste();
        storage.put(freeSpace, p);
        storageSpace.setUloziste(storage);
        setChanged();
        notifyObservers("objednavka cilso: "+ p.getID() +" je rdy na vyzvednuti v boxu" + name + p.getUser().getName());
        System.out.println("poslalo se info o obdrzeni zasilky");
    }

    public void requestParcelPickup(int ID, User user){
        HashMap<Integer, Package> storage= storageSpace.getUloziste();
        boolean hasID = false;
        for (Map.Entry<Integer, Package> set :
                storage.entrySet()) {
            if(set.getValue() == null || set.getValue().getID() != ID)continue;
            hasID = true;
            pickPackageId = set.getKey();
        }

        if (!hasID) return;
        Application application = new Application();
        code = application.random4Digits();
        setChanged();
        notifyObservers(code + user.getName());
        System.out.println("poslal se kod zasilky");
    }
    public Package getParcel(String code){
        if(Objects.equals(code, this.code)){
            HashMap<Integer, Package> storage= storageSpace.getUloziste();
            Package p = storage.get(pickPackageId);
            storage.put(pickPackageId, null);
            storageSpace.setUloziste(storage);
            clearAll();
            System.out.println("zasilka vyzvednuta");
            return p;
        }
        return null;
    }

    private void clearAll(){
        code = null;
        pickPackageId = -1;
    }

    public String getName() {
        return name;
    }

}
