
class GuessGameLauncher {
    public static void main( String[] args){
        GuessGame guessGame = new GuessGame();
        guessGame.start();
    }
}

class GuessGame {

    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    String status  = "game not started yet.";
    int hiddenNumber = -1;

    void start(){
        resetGame();
        System.out.println("Welcome to the Guess Games!!!");
        System.out.println("-----------------------------");
        System.out.println("Today we have 3 participants ...");
        System.out.println("May the odds be ever in your favor!");

        // starting
        setHiddenNumber();
        askForNumberToPlayers();
        checkForWinners();
        setGameStatus("first round end");

        System.out.println("-----------------------------");
        System.out.println(getGameStatus()+"...");
        System.out.println("-----------------------------");
        // results
        System.out.println("Now the results");
        System.out.println("-----------------------------");
        System.out.println("THE HIDDEN NUMBER IS...");
        System.out.println("-----------------------------");
        System.out.println(getHiddenNumber() + "!!!");
        System.out.println("-----------------------------");
        System.out.println("Winners...");
        System.out.println("-----------------------------");
        int numberOfWinners = printWinners();
        System.out.println("we have: "+numberOfWinners+" winners, congratulations.");
        System.out.println("-----------------------------");
        System.out.println("Loosers...");
        System.out.println("-----------------------------");
        int numberOfLoosers = printLoosers();
        System.out.println("-----------------------------");
        System.out.println("we have: "+numberOfLoosers+" loosers, good luck next time.");
        System.out.println("-----------------------------");
        System.out.println("The game has ended.");

    }

    void resetGame(){
        status  = "game not started yet.";
        hiddenNumber = -1;
    }

    Integer getRandomNumberBetween0and9(){
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber;
    }

    void setHiddenNumber(){
        hiddenNumber = getRandomNumberBetween0and9();
    }

    Integer getHiddenNumber(){
        return hiddenNumber;
    }

    void askForNumberToPlayers(){
        player1.guessNumber();
        player2.guessNumber();
        player3.guessNumber();
    }

    void checkForWinners(){
        int p1guess = player1.getLastGuess();
        int p2guess = player2.getLastGuess();
        int p3guess = player3.getLastGuess();

        if( p1guess >= 0 && p1guess == hiddenNumber ){
            player1.setStatus("winner! :)");
        }
        else {
            player1.setStatus("looser :(");
        }

        if( p2guess >= 0 && p2guess == hiddenNumber ){
            player2.setStatus("winner! :)");
        }
        else {
            player2.setStatus("looser :(");
        }

        if( p3guess >= 0 && p3guess == hiddenNumber ){
            player3.setStatus("winner! :)");
        }
        else {
            player3.setStatus("looser :(");
        }
    }

    void setGameStatus( String newStatus ){
        status = newStatus;
    }

    String getGameStatus(){
        return status;
    }

    Integer printWinners(){
        int countWinners = 0;
        if ( player1.getStatus() == "winner! :)" ){
            System.out.println("- Player1");
            countWinners++;
        }

        if ( player2.getStatus() == "winner! :)" ){
            System.out.println("- Player2");
            countWinners++;
        }

        if ( player3.getStatus() == "winner! :)" ){
            System.out.println("- Player3");
            countWinners++;
        }

        return countWinners;
    }


    Integer printLoosers(){
        int countLoosers = 0;
        if ( player1.getStatus() == "looser :(" ){
            System.out.println("- Player1 lost with:" + player1.getLastGuess());
            countLoosers++;
        }

        if ( player2.getStatus() == "looser :(" ){
            System.out.println("- Player2 lost with:" + player2.getLastGuess());
            countLoosers++;
        }

        if ( player3.getStatus() == "looser :(" ){
            System.out.println("- Player3 lost with:" + player3.getLastGuess());
            countLoosers++;
        }

        return countLoosers;
    }

}

class Player {
    String role = "no role yet.";
    String status = "playing.";
    int lastGuess = -1;

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
    
    Integer getLastGuess(){
        return lastGuess;
    }
}

