import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Gamer!");
        int computer = 0;
        int human = 0;

        gameplay();

        if (askReplay()) {
            gameplay();
        } else {
            scoreCard(computer, human);
        }


//        TODO: Computer asks what your choice is
//        TODO: Computer makes a choice
//        TODO: Computer declares a round winner
//        TODO: Computer asks if you want to play again
//        TODO: Computer responds appropriately
    }
    public static void gameplay(){
        Scanner invitation = new Scanner(System.in);
        System.out.print("Do you want to play a game of Rock, Paper, Scissors with me? (y/n): ");
        String response = invitation.next();
        char decision = response.charAt(0);
        boolean len = response.length() == 1;
        if (decision == 'y' && len) {
            System.out.println("Great let's play!");
            String playerChoice = playerChoice();
            String computerChoice = computerChoice();
            winnerDeclaration(playerChoice,computerChoice);
        };
        if (decision == 'n' && len) System.out.println("Maybe next time.");
        if ((decision != 'n' && decision != 'y') || !len) {
            System.out.println("Please respond with either 'y' or 'n'.");
            gameplay();
        }
    }

    public static String playerChoice() {
        Scanner askPlayer = new Scanner(System.in);
        System.out.print("Choose one: Rock, Paper or Scissors: ");
        String playerChoice = askPlayer.next().toLowerCase();
        if (!checkValid(playerChoice)) {
            System.out.println("Please choose rock, paper or scissors");
            playerChoice = "";
        }
        return playerChoice.length() != 0 ? playerChoice : playerChoice();
    }
    public static boolean checkValid(String player) {
        return player.equals("rock") || player.equals("paper") || player.equals("scissors");
    }
    public static String computerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int) Math.floor(Math.random() * 2.999);
        return choices[index];
    }
    public static void winnerDeclaration(String player, String computer){
        switch (player){
            case "rock":
                if(computer.equals("rock")) System.out.println("I chose rock, it's a tie");
                if(computer.equals("paper")) System.out.println("I chose paper, so I win");
                if(computer.equals("scissors")) System.out.println("I chose scissors, so you win");
                break;
            case "paper":
                if(computer.equals("rock")) System.out.println("I chose rock, so you win");
                if(computer.equals("paper")) System.out.println("I chose paper, it's a tie");
                if(computer.equals("scissors")) System.out.println("I chose scissors, so I win");
                break;
            case "scissors":
                if(computer.equals("rock")) System.out.println("I chose rock, so I win");
                if(computer.equals("paper")) System.out.println("I chose paper, so you win");
                if(computer.equals("scissors")) System.out.println("I chose scissors, it's a tie");
                break;
        }
    }

    public static boolean askReplay(){
        Scanner replay = new Scanner(System.in);
        System.out.print("Do you want a rematch? (y/n): ");
        String response = replay.next().toLowerCase();
        boolean choice;
        if(response.equals("y")  || response.equals("yes")) choice = true;
        else if (response.equals("n") || response.equals("no")) choice = false;
        else {
            System.out.println("You have not responded in the affirmative or negative, so I'll terminate the game here.");
            choice = false;
        }
        return choice;
    }

    public static void scoreCard(int c, int h){
        System.out.println("Thank you for playing with me!");
        if (c == h) {
            System.out.println("Our game series has led to a Tie with the final score being \nYou: " + h + " Me: " + c + "\nYou were a worthy opponent.");
        };
        if (c > h) {
            System.out.println("The score card shows that I won with the final score being \nYou: " + h + " Me: " + c);
        };
        if (c < h) {
            System.out.println("The score card shows that You won with the final score being \nYou: " + h + " Me: " + c + "\nCongratulations!!!");
        };
    }

}