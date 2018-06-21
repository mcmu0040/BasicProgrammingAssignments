/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmentbasicprogrammingconcepts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mcmu0
 */
public class RPSLSpock {

    public static Scanner sc = new Scanner(System.in);
    public static Random r = new Random();
    
    public static void main(String[] args) {
        System.out.println("Are you ready to play ROCK PAPER SCISSORS LIZARD SPOCK?!?!");
        
        boolean play = true;
        int rounds;
        
        while (play) {
            //re-initialize couners every round
            int wins = 0;
            int losses = 0;
            int ties = 0;
            
            String user, computer; //variables to store their choices
            String winner; //var to hold winner of the round
            
            System.out.println("How many rounds do you want to play? ");
            
            rounds = confirmRounds();

            for (int i = 0; i < rounds; i++) {
                user = userChoice(); //prompt user make a choice
                computer = computerChoice(); //have computer make a choice
                
                winner = chooseWinner(user, computer); //does the comparissons, done for readability
                
                if (winner.equals("user")) {
                    wins++;
                } else if (winner.equals("computer")) {
                    losses++;
                } else if (winner.equals("tie")) {
                    ties++;
                } else {
                    System.out.println("Error, winner not chosen propperly. All hail the machines."); 
                    i = rounds;
                    break;
                    //chooseWinner only outputs "user", "computer", or "tie". 
                    //This else statement catches all erros and exits from the for loop.
                }
            } //exit of for loop of rounds
            
            
            declareWinner(wins, losses, ties);
            
            System.out.print("Would you like to play again? (y/n) ");
            String again = sc.nextLine();
            
            if (again.equalsIgnoreCase("y")) {
                play = true;
            } else { //if the user enters anything but 'y', exit the game
                System.out.println("Thanks for playing.");
                play = false;
            }
            
        }
    }
    
    public static int confirmRounds() {
        int temp = 0;
        int maxRounds = 10; //easy way to change the max rounds a game is played.
        boolean goodValue = false;
        
        while (!goodValue) {
            System.out.print("Please enter the number of rounds (1-10): ");
            String tempString = sc.nextLine();
            
            if (tempString.isEmpty()) {
                goodValue = false;
                System.out.println("Please make an entry.");
            } else {
                temp = Integer.parseInt(tempString);
                if (temp >= 1 && temp <= maxRounds) { //if temp is an int between 1 and 10
                    goodValue = true;
                } else {
                    goodValue = false;
                    System.out.println("That is not a valid selection. Please enter a value between 1 and " + maxRounds + ".");
                }
            }
        }
        return temp;
    }
    
    public static String userChoice() { //returns valid user choice
        String choice = "Oops";
        String temp = null; //used to catch error if user enters no input and just hits enter
        int input = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter your choice (Rock=1, Paper=2, Scissors=3, Lizard=4, Spock=5: ");
            temp = sc.nextLine();
                        
            if (temp.isEmpty()) { //improper entry, we need to ask again
                valid = false;
                System.out.println(choice + ", please make an entry.");
            } else {
                input = Integer.parseInt(temp);
                switch (input) {
                    case 1:
                        choice = "rock";
//                        userChoseRock++;
                        valid = true;
                    break;
                    case 2:
                        choice = "paper";
                        valid = true;
                        break;
                    case 3:
                        choice = "scissors";
                        valid = true;
                        break;
                    case 4:
                        choice = "lizard";
                        valid = true;
                        break;
                    case 5:
                        choice = "spock";
                        valid = true;
                        break;
                    default:
                        System.out.println("Not a valid selection.");
                        valid = false;
                        break;
                }
            }
        }
        return choice;
    }
    
    public static String computerChoice () {
        int temp = r.nextInt(5);
        String choice;
        
        switch (temp) {
            case 0:
                choice = "rock";
                break;
            case 1:
                choice = "paper";
                break;
            case 2:
                choice = "scissors";
                break;
            case 3:
                choice = "lizard";
                break;
            case 4:
                choice = "spock";
                break;
            default:
                System.out.println("ERROR in computerChoice()");
                choice = null;
        }
        
        return choice;
    }
    
    public static String chooseWinner(String user, String computer) {
        String result;
        
        if (user.equals("rock") && computer.equals("paper")) { //user chooses rock options
            result = "computer";
//            computerPaperBeatRock++;
            System.out.println("Paper covers Rock");
            System.out.println("Computer wins this round.");
        } else if (user.equals("rock") && computer.equals("scissors")) {
            result = "user";
            System.out.println("Rock break Scissors");
            System.out.println("User wins this round.");
        } else if (user.equals("rock") && computer.equals("lizard")) {
            result = "user";
            System.out.println("Rock crushes Lizard");
            System.out.println("User wins this round.");
        } else if (user.equals("rock") && computer.equals("spock")) {
            result = "computer";
            System.out.println("Spock vaporizes Rock");
            System.out.println("Computer wins this round.");
        } else if (user.equals("paper") && computer.equals("scissors")) { //user chooses paper options
            result = "computer";
            System.out.println("Scissors cuts Paper");
            System.out.println("Computer wins this round.");
        } else if (user.equals("paper") && computer.equals("rock")) {
            result = "user";
            System.out.println("Paper covers Rock");
            System.out.println("User wins this round.");
        } else if (user.equals("paper") && computer.equals("lizard")) {
            result = "computer";
            System.out.println("Lizard eats Paper");
            System.out.println("Computer wins this round.");
        } else if (user.equals("paper") && computer.equals("spock")) {
            result = "user";
            System.out.println("Paper disproves Spock");
            System.out.println("User wins this round.");
        } else if (user.equals("scissors") && computer.equals("paper")) { //user chooss scissors options
            result = "user";
            System.out.println("Scissors cuts Paper");
            System.out.println("User wins this round.");
        } else if (user.equals("scissors") && computer.equals("rock")) {
            result = "computer";
            System.out.println("Rock break Scissors");
            System.out.println("Computer wins this round.");
        } else if (user.equals("scissors") && computer.equals("lizard")) {
            result = "user";
            System.out.println("Scissors decapitates Lizard");
            System.out.println("User wins this round.");
        } else if (user.equals("scissors") && computer.equals("spock")) {
            result = "computer";
            System.out.println("Spock smashes Scissors");
            System.out.println("Computer wins this round.");
        } else if (user.equals("lizard") && computer.equals("spock")) { //user chooses lizard options
            result = "user";
            System.out.println("Lizard poisons Spock");
            System.out.println("User wins this round.");
        } else if (user.equals("lizard") && computer.equals("paper")) {
            result = "user";
            System.out.println("Lizard eats Paper");
            System.out.println("User wins this round.");
        } else if (user.equals("lizard") && computer.equals("rock")) {
            result = "computer";
            System.out.println("Rock crushes Lizard");
            System.out.println("Computer wins this round.");
        } else if (user.equals("lizard") && computer.equals("scissors")) {
            result = "computer";
            System.out.println("Scissors decapitates Lizard");
            System.out.println("Computer wins this round.");
        } else if (user.equals("spock") && computer.equals("rock")) { //user chooses spock options
            result = "user";
            System.out.println("Spock vaporizes Rock");
            System.out.println("User wins this round.");
        } else if (user.equals("spock") && computer.equals("scissors")) {
            result = "user";
            System.out.println("Spock smashes scissors");
            System.out.println("User wins this round.");
        } else if (user.equals("spock") && computer.equals("lizard")) {
            result = "computer";
            System.out.println("Lizard poisons Spock");
            System.out.println("Computer wins this round.");
        } else if (user.equals("spock") && computer.equals("paper")) {
            result = "computer";
            System.out.println("Paper disproves Spock.");
            System.out.println("Computer wins this round.");
        } else {
            result = "tie";
            System.out.println("This round is a tie.");
        }
        
        return result;
    }
    
    public static void declareWinner(int userWins, int computerWins, int ties) {
        System.out.println("The score was . . .");
        System.out.println("User: " + userWins);
        System.out.println("Computer: " + computerWins);
        System.out.println("Ties: " + ties);
        
        if (userWins > computerWins) {
            System.out.println("User is the overall winner.");
        } else if (userWins < computerWins) {
            System.out.println("Computer is the overall winner");
        } else {
            System.out.println("Overall this was a tie.");
        }
        
    }
}    

