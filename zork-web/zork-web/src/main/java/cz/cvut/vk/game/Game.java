package cz.cvut.vk.game;

public interface Game {

    String welcomeMessage();
    String endMessage();
    boolean isFinished();

    boolean ended();

    String processTextCommand(String line);

    long getDiference();
}
