import java.util.ArrayList;
import java.util.List;

//@author Sergey Germanov (sger197).

public class MultiMethods {
    PrintOUTS print = new PrintOUTS();
    String playersInput;
    String computerNumber;
    String secretCode;
    String computerGuess;
    boolean guessed = false;
    boolean guessedForComp = false;
    boolean humanGuess = false;
    int guesses = 0;
    String level;
    ArrayList<String> guessesArray;
    String[] computerGuessOutList = new String[99];
    String[] yourGuessOutList = new String[99];
    String[] playersInputList = new String[99];
    String fileName;
    ArrayList<String> fileGuesses;
    String auto;
    List<String> guessesSet = new ArrayList<>();
    boolean tie = false;
    String ai;
    String guessesChoice;

    //    variables for saving to file
    String outPutFileName;
    String computerGuessOut;
    String yourGuessOut;
    String result;

    //    check players keayboard input and give prompts
    public boolean checkKeyboardInput( String number,int aiChoice ) {
        if (number.length() == aiChoice) {
            try {
                Integer.parseInt( number );
            } catch (NumberFormatException secondTry) {
                print.inputNotValid();
                return false;
            }
            if (!computerCheckNumber( number ) && aiChoice != 2) {
                print.noDoubles();
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println(print.notLongEnough( aiChoice ));
        }
        return false;
    }

    //check computers number for doubles and return boolean
    public boolean computerCheckNumber( String number ) {
        for (int i = 0; i < number.length(); i++) {
            char A = number.charAt( i );
            for (int j = 0; j < number.length(); j++) {
                char B = number.charAt( j );
                if (i != j && A == B) {
                    return false;
                }
            }
        }
        return true;
    }

    //create and reassign new computer's 4 digit guess
    public String reassignNumber() {
        String newNumber = (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + (int) (Math.random() * 10) + (int) (Math.random() * 10);
        return newNumber;
    }

    //        creates Set full of possible guesses in hardAI
    public void combinations() {
        for (int i = 122; i < 9999; i++) {
            String stringNumber = String.valueOf( i + 1 );
            if (stringNumber.length() == 3) {
                stringNumber = "0" + stringNumber;
            }
            if (computerCheckNumber( stringNumber )) {
                guessesSet.add( stringNumber );
            }
        }
    }

    //            check for bulls and cows and return string for hardAI
    public String checkForBulls( String number,String player ) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < 4; i++) {
            if (player.charAt( i ) == number.charAt( i )) {
                bulls++;
            } else if (player.contains( number.charAt( i ) + "" )) {
                cows++;
            }
        }
        return bulls + "" + cows;
    }
    //    starts taking the guesses from the file or asks user for the input
    public void autoGuessingMethod() {
        if (auto.equals( "1" )) {

            try {
                playersInput = fileGuesses.get( 0 );
                fileGuesses.remove( 0 );
            } catch (IndexOutOfBoundsException e) {
                youGuess();
            }
        }
        if (auto.equals( "2" )) {
            youGuess();
        }
    }

    //asks for users guess
    public void youGuess() {
        print.enterYourGuess();
        keyboardCheckWhile( 4,false );
    }

    //check the validity of all the keyboard inputs
    public void keyboardCheckWhile( int num,boolean code ) {
        String input;
        while (true) {
            if (num == 4 && !code) {
                playersInput = Keyboard.readInput();
                input = playersInput;
                playersInputList[guesses] = playersInput;
            } else if (num == 4 && code) {
                secretCode = Keyboard.readInput();
                input = secretCode;
            } else if (num == 1 && !code) {
                level = Keyboard.readInput();
                input = level;
            } else {
                guessesChoice = Keyboard.readInput();
                if (guessesChoice.length() == 1) {
                    input = "0" + guessesChoice;
                } else {
                    input = guessesChoice;
                }
            }
            if (checkKeyboardInput( input,num )) {
                break;
            }
        }
    }

    //check if computer Code is valid
    public void checkAndReassignNumber( boolean code ) {
        String input;
        while (true) {
            input = reassignNumber();
            if (computerCheckNumber( input )) {
                if (code) {
                    computerGuess = input;
                    guessesArray.add( computerGuess );
                } else {
                    computerNumber = input;
                }
                break;
            }
        }
    }

    //check the number for bulls and cows and prints out the result
    public void checkNumber( String number,String player ) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            if (player.charAt( i ) == number.charAt( i )) {
                bulls++;
            } else if (player.contains( number.charAt( i ) + "" )) {
                cows++;
            }
        }
        if (bulls == 4) {
            guessed = true;
        } else if (number.equals( computerGuess )) {
            computerGuessOut = print.compBullsAndCows( bulls, cows );
            System.out.println( computerGuessOut );
            //            save to arraylist that then it could be saved to file
            computerGuessOutList[guesses] = computerGuessOut;
        } else if (player.equals( playersInput )) {
            yourGuessOut = print.yourBullsAndCows( bulls,cows );
            System.out.println( yourGuessOut );
            //            save to arraylist that then it could be saved to file
            yourGuessOutList[guesses] = yourGuessOut;
        }

        //  check who wins and save it array that will be used for saving to file later
        if (computerNumber.equals( playersInput ) && secretCode.equals( computerGuess )) {
            tie = true;
        } else if (secretCode.equals( computerGuess )) {
            guessedForComp = true;
        } else if (computerNumber.equals( playersInput )) {
            humanGuess = true;
            yourGuessOut = print.youGuessedCompNum();
            yourGuessOutList[guesses] = yourGuessOut;
        }
    }
}