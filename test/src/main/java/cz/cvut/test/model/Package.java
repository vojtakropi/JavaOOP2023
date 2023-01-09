package cz.cvut.test.model;

public class Package {

    private User user;
    private int ID;

    public Package(User user, int ID) {
        this.user = user;
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public int getID() {
        return ID;
    }
}
