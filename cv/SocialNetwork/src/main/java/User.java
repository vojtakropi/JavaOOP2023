package SocialNetwork.src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class User implements Observer {

    private String nickname;

    private String email;

    private String password;

    public Feed getFeed() {
        return feed;
    }

    private Feed feed;
    private List<String> feeds = new ArrayList<>();


    private List<User> friends = new ArrayList<>();

    public String getNickname() {
        return nickname;
    }


    public String getEmail() {
        return email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void makePost(String post){
        Post p = new Post(post, this);
        feed.addToFeed(p);
    }

    public void AddFriend(User user){
        friends.add(user);
        if (!user.friends.contains(this)){
            user.AddFriend(this);
            feed.addObserver(user);
        }
        Feed frinedfeed = user.getFeed();
        frinedfeed.addObserver(this);
    }

    public String printFeed(){
        return feeds.toString();
    }

    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        feed = new Feed();
        feed.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        feeds.add(arg.toString());
    }
}
