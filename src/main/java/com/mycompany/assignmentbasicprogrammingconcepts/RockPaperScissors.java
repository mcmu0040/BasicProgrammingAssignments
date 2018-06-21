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
public class RockPaperScissors {

    public static Scanner sc = new Scanner(System.in);
    public static Random r = new Random();

    public static void main(String[] args) {
        System.out.println("Are you ready to play ROCK PAPER SCISSORS!!!");

        boolean play = true;
        int rounds;

        while (play) {
            //re-initialize couners every round
            int wins = 0;
            int losses = 0;
            int ties = 0;

            String user, computer; //variables to store their choices
            String winner; //var to hold winner of the round

            System.out.print("How many rounds do you want to play? ");
            System.out.println("Please enter a number between 1 and 10.");
            String temp = sc.nextLine();
            
            if (temp.isEmpty()) {
                System.out.println("You failed to make a selection. Good bye.");
                break;
            }
            
            rounds = Integer.parseInt(temp);
            if (rounds < 0 || rounds > 10) { //check for proper choice
                System.out.println("ERROR: Youd did not make a selection between 1 and 10. You chose poorly. Good bye");
                break;
            }

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

    
    public static String userChoice() { //returns valid user choice
        String choice = "Oops";
        String temp = null; //used to catch if user hits enter without making a entry
        int input = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter your choice (Rock=1, Paper=2, Scissors=3: ");
            temp = sc.nextLine();

            if (temp.isEmpty()) {
                valid = false;
                System.out.println(choice + ", please make an entry.");
            } else {
                input = Integer.parseInt(temp);
                switch (input) {
                    case 1:
                        choice = "rock";
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
                    default:
                        System.out.println("Not a valid selection.");
                        valid = false;
                        break;
                }
            }
        }

        return choice;
    }

    public static String computerChoice() {
        int temp = r.nextInt(3);
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
            default: //this should never happen with the RNG, but it should make the program more robust
                System.out.println("ERROR in computerChoice()");
                choice = null;
                break;
        }

        return choice;
    }

    public static String chooseWinner(String user, String computer) {
        String result;

        if (user.equals("rock") && computer.equals("paper")) {
            result = "computer";
            System.out.println("Paper covers Rock");
            System.out.println("Computer wins this round.");
        } else if (user.equals("rock") && computer.equals("scissors")) {
            result = "user";
            System.out.println("Rock break Scissors");
            System.out.println("User wins this round.");
        } else if (user.equals("paper") && computer.equals("scissors")) {
            result = "computer";
            System.out.println("Scissors cuts Paper");
            System.out.println("Computer wins this round.");
        } else if (user.equals("paper") && computer.equals("rock")) {
            result = "user";
            System.out.println("Paper covers Rock");
            System.out.println("User wins this round.");
        } else if (user.equals("scissors") && computer.equals("paper")) {
            result = "user";
            System.out.println("Scissors cuts Paper");
            System.out.println("User wins this round.");
        } else if (user.equals("scissors") && computer.equals("rock")) {
            result = "computer";
            System.out.println("Rock break Scissors");
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
