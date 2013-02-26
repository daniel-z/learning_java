import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

class GameConfig {

     private int rounds = 1;
     private int numberOfPlayers = 12;
     private List<String> playerNames = new ArrayList<String>(Arrays.asList("Juan", "Carlos",
         "Ramiro", "Eve", "Laura", "Florence", "Timmoty", "Rojo", "Green", "Ramon", "Chepina",
         "Katniss"));
     private boolean stopAtFirstWin = true;

     int getNumberOfPlayers(){
         return numberOfPlayers;
     }

     void setNumberOfPlayers(int newNumberOfPlayers){
         numberOfPlayers = newNumberOfPlayers;
     }

     int getNumberOfRounds(){
         return rounds;
     }

     void setNumberOfRounds(int newRounds){
         rounds = newRounds;
     }

     List<String> getPlayerNames(){
         return playerNames;
     }

     void setPlayerNames(List<String> newPlayerNames){
         playerNames = newPlayerNames;
     }

     boolean mustStopAtFirstWin(){
         return stopAtFirstWin;
     }

     void setStopAtFirstWin(boolean newStopAtFirstWin){
         stopAtFirstWin = newStopAtFirstWin;
     }

}

class GameMenu {

    private GameConfig gameConfig;

    public GameMenu ( GameConfig config ){
        gameConfig = config;
    }

    void printWelcome(){
        printLongLine();
        System.out.println("Welcome to the Guess Games!!!");
        printLongLine();
        System.out.println("Today we have "+ gameConfig.getNumberOfPlayers() +" participants ...");

        List<String> players = gameConfig.getPlayerNames();
        int district = 0;

        for ( String name : players ) {
            district++;
            System.out.println("from district "+district+": "+name);
        }

        printLongLine();
        System.out.println("May the odds be ever in your favor!");
    }

    void printDefaultConfig(){
        printLongLine();
        System.out.println("Default Game Config:");
        System.out.println("Number of Rounds: " + gameConfig.getNumberOfRounds());
        System.out.println("Number of Players: " + gameConfig.getNumberOfPlayers());
        System.out.println("Player names:" + gameConfig.getPlayerNames());
        System.out.println("Is the game stopping at first win?: "+gameConfig.mustStopAtFirstWin());
    }

    void printLongLine (){
        System.out.println("-------------------------------------");
    }

    void printShortLine (){
        System.out.println("---------------");
    }
}

class Player {
    String role = "no role yet.";
    String status = "playing.";
    int lastGuess = -1;
    String name = "";

    Integer guessNumber() {
        int randomNumber = (int) (Math.random() * 10);
        lastGuess = randomNumber;
        return randomNumber;
    }

    void setRole( String newRole ){
        role = newRole;
    }

    String getRole(){
        return role;
    }

    void setStatus( String newStatus ){
        status = newStatus;
    }

    String getStatus(){
        return status;
    }

    void setName( String newName ){
        name = newName;
    }

    String getName(){
        return name;
    }
    
    Integer getLastGuess(){
        return lastGuess;
    }
}

class GuessGame {

    private String status  = "game not started yet.";
    private int hiddenNumber = -1;
    private GameConfig gameConfig;
    private GameMenu gameMenu;
    private Player[] players = new Player[12];

    public GuessGame( GameConfig config, GameMenu menu ){
        gameConfig = config;
        gameMenu = menu;
        createPlayers();
    }

    void start(){
        resetGame();

        gameMenu.printWelcome();
        gameMenu.printDefaultConfig();

        runRound("Number 1");
    }

    void resetGame(){
        status  = "game not started yet.";
        hiddenNumber = -1;
    }

    private ArrayList<Player> runRound(String roundIdentifier){
        printLongLine();
        System.out.println("Starting game...");
        printLongLine();

        System.out.println("Getting hidden number..0.9.9.8.3.6.4.5.2.5.2.8.3.4.");

        setHiddenNumber();

        System.out.println("done...");
        System.out.println("Time to get player answers...");

        askForNumberToPlayers();

        System.out.println("All players answered.");
        System.out.println("Checking results...");

        ArrayList<Player> winners = checkForWinners();

        // print results
        printLongLine();
        System.out.println("Round: "+ roundIdentifier +" results:");
        printLongLine();
        System.out.println("hidden number: "+ hiddenNumber);
        printLongLine();

        if (winners != null){
            System.out.println("The next players won:");
            for ( Player player : winners ){
                System.out.println("- "+ player.getName() +"! .. congratulations.");
            }
        } else {
            System.out.println("We didn't get winners.");
        }

        printLongLine();

        return winners;
    }

    private void createPlayers(){
        List<String> playerNames = gameConfig.getPlayerNames();
        int index = 0;
        for ( String playerName : playerNames ){
            players[index] = new Player();
            players[index].setName( playerName );
            index++;
        }
    }

    private void printLongLine(){
        System.out.println("--------------------------------------");
    }

    private void printShortLine(){
        System.out.println("---------------");
    }

    private Integer getRandomNumberBetween0and9(){
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber;
    }

    private void setHiddenNumber(){
        hiddenNumber = getRandomNumberBetween0and9();
    }

    private Integer getHiddenNumber(){
        return hiddenNumber;
    }

    private void askForNumberToPlayers(){
        for ( Player player : players ){
            player.guessNumber();
        }
    }

    private ArrayList<Player> checkForWinners(){
        ArrayList<Player> winners = new ArrayList<Player>();
        int winnerIndex = 0;
        for ( Player player : players ){
            int guess = player.getLastGuess();
            if ( guess == hiddenNumber ){
                winners.add(player);
                winnerIndex++;
            }
        }
        return winners;
    }

    private void setGameStatus( String newStatus ){
        status = newStatus;
    }

    private String getGameStatus(){
        return status;
    }
}


class GuessGameLauncher {
    public static void main(String[] args){
        GameConfig config = new GameConfig();
        GameMenu menu = new GameMenu(config);
        GuessGame guessGame = new GuessGame(config, menu);
        guessGame.start();
    }
}




