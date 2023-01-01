package SocialNetwork.src.main.java;

public class Post {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private final String text;
    private final User user;


    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }


    public String workPost(){
        return ANSI_GREEN + java.time.LocalDate.now() +" ; " + user.getNickname() + ": " + text + ANSI_RESET + "\n";
    }

    public String workPost(String group){
        return ANSI_RED_BACKGROUND + java.time.LocalDate.now() + ", " + group +" ; " + user.getNickname() + ": " + text + ANSI_RESET  + "\n";
    }
}
