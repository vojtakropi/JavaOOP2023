package SocialNetwork.src.main.java;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    List<User> users = new ArrayList<>();

    List<Group> groups = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public List<Group> getGroups() {
        return groups;
    }


    public void registerUser(User user){
        if(users.stream().anyMatch(o -> o.getNickname().equals(user.getNickname())) || users.stream().anyMatch(o -> o.getEmail().equals(user.getEmail()))){
            System.out.println("user with this nickname or email already exists");
            return;
        }
        users.add(user);
    }
    public void registerGroup(Group group){
        if(groups.stream().anyMatch(o -> o.getName().equals(group.getName()))){
            System.out.println("group with this name already exists");
            return;
        }
        groups.add(group);
    }
}
