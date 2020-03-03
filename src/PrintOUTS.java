//@author Sergey Germanov (sger197).

public class PrintOUTS {
    public void cow() {
        System.out.println( "                      \t        /)  (\\" );
        System.out.println( "                           .~._((,\"\".))_.~," );
        System.out.println( "                            `~.   uu   ,~'" );
        System.out.println( "                              / ,n~~n. \\" );
        System.out.println( "                             { { .__. } }" );
        System.out.println( "                              ) `~~~~' (" );
        System.out.println( "                             /`-._  _.-'\\" );
        System.out.println( "                            /            \\" );
        System.out.println( "                          ,-X            X-." );
        System.out.println( "                         /   \\          /   \\" );
        System.out.println( "                        (     )| |  | |(     )" );
        System.out.println( "                         \\   / | |  | | \\   /" );
        System.out.println( "                          \\_(.-( )--( )-.)_/" );
        System.out.println( "                          /_,\\ ) /  \\ ( /._\\" );
        System.out.println( "                              /_,\\  /._\\" );
        System.out.println( " _           _ _                       " );
        System.out.println( "| |         | | |                       _" );
        System.out.println( "| |__  _   _| | | ___                  | |" );
        System.out.println( "| '_ \\| | | | | |/ __|   __ _ _ __   __| |" );
        System.out.println( "| |_) | |_| | | |\\__ \\  / _` | '_ \\ / _` |" );
        System.out.println( "|_.__/ \\__,_|_|_||___/ | (_| | | | | (_| |  ___ _____      __ ___" );
        System.out.println( "                        \\__,_|_| |_|\\__,_| / __/ _ \\ \\ /\\ / // __|" );
        System.out.println( "                                          | (_| (_) \\ V  V / \\__ \\" );
        System.out.println( "                                           \\___\\___/ \\_/\\_/  |___/" );

    }

    public void guessNumber() {
        System.out.println("==================================================================");
        System.out.println( "Do you want to enter guesses yourself or taken from a file." );
    }

    public void chooseInputFile() {
        System.out.println( "Please enter the valid file name with pre-supplied guesses." );
    }

    public void difficultyLevel() {
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
        System.out.println( "How smart do you want me to be?" );
        System.out.println( "                \\" );
        System.out.println( "                  _____/\\_/\\______" );
        System.out.println( "                 \"~~~,-.,~. \",~~~~\"" );
        System.out.println( "                    (, (,  ) \\" );
        System.out.println( "                     -=\"=-\"   \\" );
        System.out.println( "                    /          \\" );
        System.out.println( "                  ,'     ,.-:   \\" );
        System.out.println( "               `,' `. ,~'   !    \\" );
        System.out.println( "              -( :\";|' ,+,  '     \\" );
        System.out.println( "                \\`'   C_.','" );
        System.out.println( "                '`---~--~\"" );
        System.out.println( "                       |" );
        System.out.println( "Choose your difficulty level." );
        System.out.println( "1 is for easy" );
        System.out.println( "2 is for medium" );
        System.out.println( "3 is for hard" );
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
    }

    public void chooseGuesses() {
        System.out.println( "Choose the number of guesses. The number must be from 01 to 99." );
    }

    public void secretCodeInput() {
        System.out.println( "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
        System.out.println( "Each player chooses a secret code of 4 digits from 0 - 9." );
        System.out.println( "THE DIGITS MUST BE ALL DIFFERENT!" );
        System.out.println( "Please enter your secret code:" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
    }

    public void secretNumberPrint( String secretCode ) {
        System.out.println( "Your secret number is: " + secretCode );
    }
//this method is used for debugging perposes to see computers code
//    public void computerSecret( String computerNumber ) {
//        System.out.println( "Computer's number is: " + computerNumber );
//    }

    public void saveOrNot() {
        System.out.println("--------------------------------------------------------------");
        System.out.println( "Do you want to save the results to the file?" );
    }

    public void thanks() {
        System.out.println( "                 (      )" );
        System.out.println( "                 ~(^^^^)~" );
        System.out.println( "                  ) @@ \\~_          |\\" );
        System.out.println( "                 /     | \\        \\~ /" );
        System.out.println( "                ( 0  0  ) \\        | |       Hey" );
        System.out.println( "                 ---___/~  \\       | |           where're" );
        System.out.println( "                  /'__/ |   ~-_____/ |                     Goin?" );
        System.out.println( "   o          _   ~----~      ___---~" );
        System.out.println( "     O       //     |         |" );
        System.out.println( "            ((~\\  _|         -|                Oops! I mean MOOOOOOO" );
        System.out.println( "      o  O //-_ \\/ |        ~  |" );
        System.out.println( "           ^   \\_ /         ~  |" );
        System.out.println( "                  |          ~ |" );
        System.out.println( "                  |     /     ~ |" );
        System.out.println( "                  |     (       |" );
        System.out.println( "                   \\     \\      /\\" );
        System.out.println( "                  / -_____-\\   \\ ~~-*" );
        System.out.println( "                  |  /       \\  \\       .==." );
        System.out.println( "                  / /         / /       |  |" );
        System.out.println( "                /~  |      //~  |       |__|" );
        System.out.println( "                ~~~~        ~~~~" );
        System.out.println( "==========================================================" );
        System.out.println( "\n" );
        System.out.println( "               Thank you! Bye-bye." );
    }

    public void turnStatistics( String playersInput,String secretCode,String computerNumber,String computerGuess ) {
        System.out.println( "Your guess is: " + playersInput );
//        these sout are used for debugging perporses. To see computers code.
//        System.out.println( "Your Secret Code: " + secretCode );
//        System.out.println( "Computer's Secret Code is: " + computerNumber );
        System.out.println( "Computer's guess is: " + computerGuess );
        System.out.println( "                            .-." );
        System.out.println( "                           ##  )" );
        System.out.println( "                               *" );
        System.out.println( "                         _.-+*'`*+-._" );
        System.out.println( "                       ,##  _    _   #." );
        System.out.println( "                      ;### ((.;;.))  ##:" );
        System.out.println( "                .=._.;    ,-*:;;:*-. *##:._.=," );
        System.out.println( "                 >##;    *-')_@@_(`-*   ;###<" );
        System.out.println( "---------------`****------(o `` o)-----*****'----------------" );
        System.out.println( "                            `-\"\"-'       " );
    }

    public String bothLostStr() {
        return "You both lost. LOOSERS!";
    }

    public String computerWonStr( int guesses ) {
        return "Computer won after " + guesses + " guesses.";
    }

    public String youWonStr( int guesses ) {
        return "You won after " + guesses + " guesses.";
    }

    public String finishInTieStr( int guesses ) {
        return "You finished in a tie after " + guesses + " guesses.";
    }

    public void enterOnceAgain() {
        System.out.println( "Please enter once again." );
    }

    public void saveResults() {
        System.out.println( "Please enter the file name to save the results" );
    }

    public void ifYes() {
        System.out.println( "If yes type - 1 // If no type - 2" );
    }

    public String title() {
        return "Bulls & Cows Results";
    }

    public String aiTitle() {
        return "Computer's AI is ";
    }

    public String yourCodeResults() {
        return "Your code: ";
    }

    public String compCodeResults() {
        return "Computer's code: ";
    }

    public String dash() {
        return "---";
    }

    public String turn( int i ) {
        return "Turn " + (i + 1) + ":";
    }

    public String computerGuess() {
        return "Computer guess is: ";
    }

    public String compGuessed() {
        return "Computer guessed your Secret Code.";
    }

    public String yourGuess() {
        return "Your guess is: ";
    }

    public String errorMessage() {
        return "Error: ";
    }

    public void inputNotValid() {
        System.out.println( "Your input is NOT digits. Please enter once again." );
    }

    public void noDoubles() {
        System.out.println( "THE DIGITS MUST BE ALL DIFFERENT!" );
    }

    public String notLongEnough( int aiChoice ) {
        return "Your input is NOT " + aiChoice + " digit long. Please enter once again.";
    }

    public void enterYourGuess() {
        System.out.println( "Enter your guess:" );
    }

    public String compBullsAndCows( int bulls,int cows ) {
        return "Computer's guess got: " + cows + " Cows and " + bulls + " Bulls.";
    }

    public String yourBullsAndCows( int bulls,int cows ) {
        return "Your guess got: " + cows + " Cows and " + bulls + " Bulls.";
    }

    public String youGuessedCompNum() {
        return "You guessed Computer's Secret Code.";
    }
}
