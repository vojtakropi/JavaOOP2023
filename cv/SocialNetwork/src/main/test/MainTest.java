package SocialNetwork.src.main.test;

import SocialNetwork.src.main.java.Group;
import SocialNetwork.src.main.java.SocialNetwork;
import SocialNetwork.src.main.java.User;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testFeed(){
        SocialNetwork facebook = new SocialNetwork();
        Group pejkari = new Group("pejkari");
        Group kockari = new Group("Kockari");
        facebook.registerGroup(pejkari);
        facebook.registerGroup(kockari);
        User u1 = new User("u1", "bla@seznam.cz", "jsjs");
        User u2 = new User("u2", "blae@seznam.cz", "jsjs");
        User u3 = new User("u3", "blac@seznam.cz", "jsjs");
        User u4 = new User("u4", "blace@seznam.cz", "jsjs");
        facebook.registerUser(u1);
        facebook.registerUser(u2);
        facebook.registerUser(u3);
        facebook.registerUser(u4);
        u2.AddFriend(u3);
        u2.AddFriend(u4);
        u1.AddFriend(u2);
        u1.AddFriend(u3);
        u1.AddFriend(u4);
        pejkari.AddMember(u3);
        pejkari.AddMember(u4);
        kockari.AddMember(u2);
        kockari.AddMember(u1);
        u3.makePost("nemam rad kocky");
        pejkari.PostToGroup(u3, "mam damlatyna");
        u1.makePost("kiki je krava");
        kockari.PostToGroup(u2, "mam zrzavou");
        String u1feed = u1.printFeed();
        String u2feed = u2.printFeed();
        String u3feed = u3.printFeed();
        String u4feed = u4.printFeed();
        String pejskarifeed = pejkari.PrintFeed();
        String kockarifeed = kockari.PrintFeed();
    }
}
