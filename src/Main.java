import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Gamer!");
//        TODO: Computer asks if you want to play rock, paper, scissors
            invite();
//        TODO: Computer asks what your choice is
            String playerChoice = playerChoice();
//        TODO: Computer makes a choice
            String computerChoice = computerChoice();
//        TODO: Computer declares a round winner
            winnerDeclaration(playerChoice,computerChoice);
//        TODO: Computer asks if you want to play again
//        TODO: Computer responds appropriately
    }
    public static void invite(){
        Scanner invitation = new Scanner(System.in);
        System.out.print("Do you want to play a game of Rock, Paper, Scissors with me? (y/n): ");
        String response = invitation.next();
        char decision = response.charAt(0);
        boolean len = response.length() == 1;
        if (decision == 'y' && len)  System.out.println("Great let's play!");
        if (decision == 'n' && len) System.out.println("Maybe next time.");
        if ((decision != 'n' && decision != 'y') || !len) {
            System.out.println("Please respond with either 'y' or 'n'.");
            invite();
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

}