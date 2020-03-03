import java.io.*;
import java.util.ArrayList;
import java.util.List;

//@author Sergey Germanov (sger197).

public class Game extends MultiMethods {
    PrintOUTS print = new PrintOUTS();

    public void start() {
        print.cow();
        print.guessNumber();
        saveOrNot();

        if (auto.equals( "1" )) {
            while (true) {
                print.chooseInputFile();
                fileName = Keyboard.readInput();
                if (fileRead( fileName )) {
                    break;
                }
            }
        }

        print.difficultyLevel();
        keyboardCheckWhile( 1,false );
        print.chooseGuesses();
        keyboardCheckWhile( 2,false );
        print.secretCodeInput();
        keyboardCheckWhile( 4,true );
        print.secretNumberPrint( secretCode );
        checkAndReassignNumber( false );
//        this line is used for debugging perposes to see computers code
//        print.computerSecret( computerNumber );

        if (level.equals( "3" )) {
            combinations();
        }

        findTheWinner();
        print.saveOrNot();
        saveOrNot();

        if (auto.equals( "1" )) {
            saveToFile();
        }
        print.thanks();
    }

    // easy AI method
    public void easyAI() {
        autoGuessingMethod();
        checkAndReassignNumber( true );
        checkNumber( computerNumber,playersInput );
        checkNumber( computerGuess,secretCode );
        print.turnStatistics( playersInput, secretCode, computerNumber, computerGuess );
    }

    // medium AI method
    public void mediumAI() {
        autoGuessingMethod();
        checkNumber( computerNumber,playersInput );
        while (true) {
            computerGuess = reassignNumber();
            if (computerCheckNumber( computerGuess )) {
                if (!guessesArray.contains( computerGuess )) {
                    guessesArray.add( computerGuess );
                    break;
                }
            }
        }
        checkNumber( computerGuess,secretCode );
        print.turnStatistics( playersInput, secretCode, computerNumber, computerGuess );
    }

    // hard AI method
    public void hardAI() {
        autoGuessingMethod();
        returnGuess();
        print.turnStatistics( playersInput, secretCode, computerNumber, computerGuess );
    }

    //    returns one random number from the list in hardAI
    private void newNumber() {
        String number;
        number = guessesSet.get( (int) (Math.random() * guessesSet.size()) );
        computerGuess = number;
        guessesArray.add( computerGuess );
    }

    //gives new numbers Computer's numbers and check for winners
    private void returnGuess() {
        checkNumber( computerNumber,playersInput );
        newNumber();
        compareToTheGuess( computerGuess,secretCode );
    }

    //remove unnecessary guess from the guesses array list in hardAI
    private void compareToTheGuess( String number,String player ) {
        List<String> newGuessSet = new ArrayList<>();
        String cowsBullsForSecreteCode = checkForBulls( number,player );
        for (String s : guessesSet) {
            if (checkForBulls( number,s ).equals( cowsBullsForSecreteCode )) {
                newGuessSet.add( s );
            }
        }
        checkNumber( number,secretCode );
        guessesSet = newGuessSet;
    }

    // choose the AI level finds out who is the winner
    public void findTheWinner() {
        guessesArray = new ArrayList<>();
        int number = Integer.parseInt( guessesChoice );
        while (!guessed && guesses != number) {
            switch (level) {
                case "1":
                    ai = "EASY";
                    easyAI();
                    break;
                case "2":
                    ai = "MEDIUM";
                    mediumAI();
                    break;
                case "3":
                    ai = "HARD";
                    hardAI();
                    break;
            }
            guesses++;
            if (guesses == number && !guessed) {
                result = print.bothLostStr();
                System.out.println(print.bothLostStr());
            } else if (guessedForComp && !tie) {
                result = print.computerWonStr( guesses );
                System.out.println(print.computerWonStr( guesses ));
            } else if (humanGuess && !tie) {
                result = print.youWonStr( guesses );
                System.out.println(print.youWonStr( guesses ));
            } else if (tie) {
                result = print.finishInTieStr( guesses );
                System.out.println(print.finishInTieStr( guesses ));
            }
        }
    }

    //    reads the guesses from a given file
    public boolean fileRead( String fileName ) {
        File firstFile = new File( fileName + ".txt" );
        try (BufferedReader reader = new BufferedReader( new FileReader( firstFile ) )) {
            fileGuesses = new ArrayList<>();
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                fileGuesses.add( line );
                playersInputList[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println( print.errorMessage() + e.getMessage() );
            print.enterOnceAgain();
            return false;
        }
        return true;
    }

    //    save results to the file
    public void saveToFile() {
        print.saveResults();
        outPutFileName = Keyboard.readInput();
        File firstFile = new File( outPutFileName + ".txt" );
        try (BufferedWriter bW = new BufferedWriter( new FileWriter( firstFile ) )) {
            bW.write( print.title() );
            bW.newLine();
            bW.write( print.aiTitle() + ai );
            bW.newLine();
            bW.write( print.yourCodeResults() + secretCode );
            bW.newLine();
            bW.write( print.compCodeResults() + computerNumber );
            bW.newLine();
            bW.write( print.dash() );
            bW.newLine();

            for (int i = 0; i < guesses; i++) {
                bW.write( print.turn( i ) );
                bW.newLine();
                bW.write( print.computerGuess() + guessesArray.get( i ) );
                bW.newLine();
                if (computerGuessOutList[i] == null) {
                    computerGuessOutList[i] = print.compGuessed();
                }
                bW.write( computerGuessOutList[i] );
                bW.newLine();
                bW.write( print.yourGuess() + playersInputList[i] );
                bW.newLine();
                bW.write( yourGuessOutList[i] );
                bW.newLine();
                bW.write( print.dash() );
                bW.newLine();

            }
            bW.write( result );
        } catch (IOException e) {
            System.out.println( print.errorMessage() + e.getMessage() );
        }
    }

//    asks if I need to save the results or not
    public void saveOrNot() {
        print.ifYes();
        while (true) {
            auto = Keyboard.readInput();
            if (auto.equals( "1" ) || auto.equals( "2" )) {
                break;
            } else {
                print.enterOnceAgain();
            }
        }
    }

    public static void main( String[] args ) {
        Game ex = new Game();
        ex.start();
    }
}
