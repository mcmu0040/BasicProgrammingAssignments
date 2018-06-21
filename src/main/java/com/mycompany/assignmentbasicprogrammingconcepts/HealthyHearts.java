package com.mycompany.assignmentbasicprogrammingconcepts;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcmu0
 */
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is your age? ");
        int age = Integer.parseInt(sc.nextLine());
        int maxHR = 220 - age;
        
        System.out.println("Your maximum heart rate should be " + maxHR + " beats per minute.");
        
        System.out.println("Your target HR Zone is " + (maxHR / 2) + " - " + (maxHR * 85 / 100) + " beats per minute.");
    }
    
}
