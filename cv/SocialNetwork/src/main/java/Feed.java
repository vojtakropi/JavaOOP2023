package SocialNetwork.src.main.java;


import java.util.Observable;

public class Feed extends Observable {

    private String thread;


    public void addToFeed(Post post){
        thread = post.workPost();
        setChanged();
        notifyObservers(thread);
    }
    public void addToFeed(Post post, Group group){
        thread = post.workPost(group.getName());
        setChanged();
        notifyObservers(thread);
    }
}
