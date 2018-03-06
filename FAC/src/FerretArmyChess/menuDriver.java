package FerretArmyChess;

import javax.swing.*;

public class menuDriver {
    public static void main(String[] args) {
        MainMenu.main();
    }
    public static void GameSetupCall(){
        GameSetup.main();
    }
    public static void LaunchGame(){
        Game _game = new Game();

    }

}
