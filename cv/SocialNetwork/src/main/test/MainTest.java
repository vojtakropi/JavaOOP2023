package SocialNetwork.src.main.test;

import SocialNetwork.src.main.java.Group;
import SocialNetwork.src.main.java.SocialNetwork;
import SocialNetwork.src.main.java.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testFeed(){
        SocialNetwork facebook = new SocialNetwork();
        Group pejkari = new Group("pejskari");
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
        u1.makePost("kiki je blba");
        kockari.PostToGroup(u2, "mam zrzavou");
        String u1feed = u1.printFeed();
        Assertions.assertTrue(u1feed.contains("u3") && u1feed.contains("u1") && u1feed.contains("Kockari") && u1feed.contains("u2"));
        Assertions.assertFalse(u1feed.contains("u4") ||  u1feed.contains("pejkari"));
        String u2feed = u2.printFeed();
        Assertions.assertTrue(u2feed.contains("u3") && u2feed.contains("u1") && u2feed.contains("Kockari") && u2feed.contains("u2"));
        Assertions.assertFalse(u2feed.contains("u4") || u2feed.contains("pejkari"));
        String u3feed = u3.printFeed();
        Assertions.assertTrue(u3feed.contains("u3") && u3feed.contains("u1") && u3feed.contains("pejskari"));
        Assertions.assertFalse(u3feed.contains("u4") || u3feed.contains("u2") || u3feed.contains("Kockari"));
        String u4feed = u4.printFeed();
        Assertions.assertTrue( u4feed.contains("u1") && u4feed.contains("pejskari") && u4feed.contains("u3"));
        Assertions.assertFalse(u4feed.contains("u4") || u4feed.contains("u2") || u4feed.contains("Kockari"));
        String pejskarifeed = pejkari.PrintFeed();
        Assertions.assertFalse(pejskarifeed.contains("u4") || pejskarifeed.contains("u2") || pejskarifeed.contains("u1"));
        String kockarifeed = kockari.PrintFeed();
        Assertions.assertFalse(kockarifeed.contains("u4") || kockarifeed.contains("u3") || kockarifeed.contains("u1"));
    }
}
