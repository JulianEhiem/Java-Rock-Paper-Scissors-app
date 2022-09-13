import java.util.Scanner;
public class Main {
    static String playerChoice = "";
    static String computerChoice = "";
    static int[] roundScore = {0, 0};
    static int[] finalScore = {0, 0};
    public static void main(String[] args) {
        gameStart();
    }
    public static void gameStart() {
        Scanner invitation = new Scanner(System.in);
        System.out.print("Do you want to play a game of Rock, Paper, Scissors with me? (y/n): ");
        String response = invitation.next();
        String[] acceptable = {"y", "n"};

        if(validate(acceptable, response)){
            if (response.equals("n")) {
                System.out.println("Maybe next time!");
                endgame();
            }
            else playerChooses();
        }
        else gameStart();
    }
    public static void endgame() {
        roundReset();
        Main.finalScore = new int[]{0, 0};
        System.out.println("\n **************\n Game Ended.\n **************");
    }
    public static boolean validate(String[] accepted, String given) {
        for (int i = 0; i < accepted.length; i++) {
            if(given.equals(accepted[i])) return true;
        };
        System.out.println("Please enter a valid response.");
        return false;
    }
    public static void playerChooses () {
        Scanner askPlayer = new Scanner(System.in);
        System.out.print("Choose one: Rock, Paper or Scissors: ");
        String playerChoice = askPlayer.next().toLowerCase();
        String[] acceptable = {"rock", "paper", "scissors", "r", "p", "s"};

        if(validate(acceptable, playerChoice)){
            Main.playerChoice = playerChoice;
            computerChooses();
        }
        else playerChooses();
    }
    public static void computerChooses() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int) Math.floor(Math.random() * 2.999);
        Main.computerChoice = choices[index];
        findWinner();
    }
    public static void findWinner() {
        String p = Main.playerChoice;
        String c = Main.computerChoice;
        String winner = "";
        switch (p.charAt(0)){
            case 'r':
                switch (c) {
                    case "rock":
                        System.out.println("I chose rock. \n ....................\nTie game! Well played! \n ....................");
                        winner = "tie";
                        break;
                    case "paper":
                        System.out.println("I chose paper.\n ....................\n I win this round! \n ....................");
                        winner = "computer";
                        break;
                    case "scissors":
                        System.out.println("I chose scissors.\n ....................\n You win this round!\n ....................");
                        winner = "human";
                        break;
                }
                break;
            case 'p':
                switch (c) {
                    case "rock":
                        System.out.println("I chose rock.\n ....................\n You win this round!\n ....................");
                        winner = "human";
                        break;
                    case "paper":
                        System.out.println("I chose paper. \n ....................\nTie game! Well played! \n ....................");
                        winner = "tie";
                        break;
                    case "scissors":
                        System.out.println("I chose scissors.\n ....................\n I win this round! \n ....................");
                        winner = "computer";
                        break;
                }
                break;
            case 's':
                switch (c) {
                    case "rock":
                        System.out.println("I chose rock.\n ....................\n I win this round! \n ....................");
                        winner = "computer";
                        break;
                    case "paper":
                        System.out.println("I chose paper.\n ....................\n You win this round!\n ....................");
                        winner = "human";
                        break;
                    case "scissors":
                        System.out.println("I chose scissors. \n ....................\n Tie game! Well played! \n ....................");
                        winner = "tie";
                        break;
                }
                break;
        }
        updateScore(winner);
    }
    public static void updateScore(String outcome) {
        switch (outcome) {
            case "human":
                Main.roundScore[1] += 1;
                Main.finalScore[1] += 1;
                break;
            case "computer":
                Main.roundScore[0] += 1;
                Main.finalScore[0] += 1;
                break;
        };
        askRematch();
    }
    public static void askRematch() {
        Scanner replay = new Scanner(System.in);
        System.out.print("Do you want a rematch? (y/n): ");
        String response = replay.next().toLowerCase();
        String[] acceptable = {"y", "n"};

        if(validate(acceptable, response)){
            if (response.equals("n")) {
                announceFinalWinner();
            }
            else {
                roundReset();
                playerChooses();
            };
        }
        else askRematch();

    }
    public static void announceFinalWinner() {
        int[] r = Main.finalScore;
        if(r[0] == r[1]){
            System.out.println("Our game series has led to a Tie with the final score being \nYou: " + r[1] + " Me: " + r[0] + "\nYou were a worthy opponent.");
        };
        if(r[0] > r[1]){
            System.out.println("The score card shows that I won with the final score being \nYou: " + r[1] + " Me: " + r[0]);
        };
        if(r[0] < r[1]){
            System.out.println("The score card shows that You won with the final score being \nYou: " + r[1] + " Me: " + r[0] + "\nCongratulations!!!");
        };
        endgame();
    }
    public static void roundReset() {
        Main.playerChoice = "";
        Main.computerChoice = "";
        Main.roundScore = new int[]{0, 0};
    }


}