import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    static int gameCount = 0;
    static int[] score = {0, 0};
    public static void main(String[] args) {
        System.out.println("Hello Gamer!");
//        int[] score = new int[2]; //c,h
        gameplay();
        scoreCard(score[0], score[1]);



//        TODO: Computer asks what your choice is
//        TODO: Computer makes a choice
//        TODO: Computer declares a round winner
//        TODO: Computer asks if you want to play again
//        TODO: Computer responds appropriately
    }
    public static void gameplay(){
        String response = "";
        if(gameCount == 0) {
            Scanner invitation = new Scanner(System.in);
            System.out.print("Do you want to play a game of Rock, Paper, Scissors with me? (y/n): ");
            response = invitation.next();
        };
        char decision = gameCount == 0 ? response.charAt(0) : 'y';
        boolean len = gameCount != 0 || response.length() == 1;
        if (decision == 'y' && len) {
            System.out.println("Great let's play!");
            String playerChoice = playerChoice();
            String computerChoice = computerChoice();
            String whoWon = winnerDeclaration(playerChoice,computerChoice);
            if(whoWon.equals("computer")) score[0]++;
            if(whoWon.equals("human")) score[1]++;
            gameCount++;
        };
        if (decision == 'n' && len) System.out.println("Maybe next time.");
        if ((decision != 'n' && decision != 'y') || !len) {
            System.out.println("Please respond with either 'y' or 'n'.");
            gameplay();
        }

        if(askReplay()) gameplay();
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
    public static String winnerDeclaration(String player, String computer){
        String winner = "";
        switch (player){
            case "rock":
                if(computer.equals("rock")) {
                    System.out.println("I chose rock, it's a tie");
                    winner = "tie";
                }
                else if(computer.equals("paper")) {
                    System.out.println("I chose paper, so I win");
                    winner = "computer";
                }
                else if(computer.equals("scissors")) {
                System.out.println("I chose scissors, so you win");
                    winner = "human";
                }
                break;
            case "paper":
                if(computer.equals("rock")) {
                    System.out.println("I chose rock, so you win");
                    winner = "human";
                }
                else if(computer.equals("paper")) {
                    System.out.println("I chose paper, it's a tie");
                    winner = "tie";
                }
                else if(computer.equals("scissors")) System.out.println("I chose scissors, so I win"); winner = "computer";
                break;
            case "scissors":
                if(computer.equals("rock")) {
                    System.out.println("I chose rock, so I win");
                    winner = "computer";
                }
                else if(computer.equals("paper")) {
                    System.out.println("I chose paper, so you win");
                    winner = "human";
                }
                else if(computer.equals("scissors")) System.out.println("I chose scissors, it's a tie"); winner = "tie";
                break;
        }
        return winner;
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