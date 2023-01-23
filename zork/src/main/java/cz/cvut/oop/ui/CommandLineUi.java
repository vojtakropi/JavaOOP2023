package cz.cvut.oop.ui;

import cz.cvut.oop.game.Game;
import cz.cvut.oop.game.GameImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 *  Represents command line ui view
 */
public class CommandLineUi {
    private static final Logger log = LoggerFactory.getLogger(CommandLineUi.class);
    private static CommandLineUi INSTANCE = new CommandLineUi();
    private Game game = new GameImpl();

    public CommandLineUi(){

    }
    //TODO NOT SINGLETON
    public static CommandLineUi getInstance(){
        return INSTANCE;
    }
    /**
     *  After ui is started, application prints welcome messages and waits for user input
     *  then proceeds to process user input and return messages back here
     *  -> to be represented on this view.
     */
    public void start(){
        log.info("application started");
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println(this.game.welcomeMessage());
            while(!this.game.isFinished()){
                System.out.print("> ");
                System.out.println(this.game.processTextCommand(scanner.nextLine()));
            }
            System.out.println(this.game.endMessage());
        }
    }

}
