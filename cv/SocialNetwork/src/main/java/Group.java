package SocialNetwork.src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Group implements Observer {

    public String getName() {
        return name;
    }

    private String name;

    private List<User> members = new ArrayList<>();

    private Feed feed;

    private List<String> feedString = new ArrayList<>();

    public Group(String name) {
        this.name = name;
        feed = new Feed();
        feed.addObserver(this);
    }

    public void AddMember(User user){
        if(members.contains(user)) {
            System.out.println("user already in group");
            return;
        }
        members.add(user);
        feed.addObserver(user);
    }

    public void PostToGroup(User user, String post){
        if(!members.contains(user)) {
            System.out.println("user not registered in group");
            return;
        }
        Post p = new Post(post, user);
        feed.addToFeed(p, this);
    }

    public String PrintFeed(){
        return feedString.toString();
    }

    @Override
    public void update(Observable o, Object arg) {
        feedString.add(arg.toString());
    }
}
