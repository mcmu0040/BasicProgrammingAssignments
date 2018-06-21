package com.mycompany.assignmentbasicprogrammingconcepts;


import java.text.DecimalFormat;
import java.util.Random;
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
public class DogGenetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        DecimalFormat df1 = new DecimalFormat("##.0");
        String dogName;
        
        System.out.print("What is your dog's name? ");
        dogName = sc.nextLine();
        
        //mehod, get 5 random numbers, sum the all all and take each individual for it's "percentage" of the whole
        int random1 = r.nextInt(10) + 1;
        int random2 = r.nextInt(10) + 1;
        int random3 = r.nextInt(10) + 1;
        int random4 = r.nextInt(10) + 1;
        int random5 = r.nextInt(10) + 1;
        
        double sum = random1 + random2 + random3 + random4 + random5;
        
//        System.out.println(random1);
//        System.out.println(sum);
//        System.out.println(random1/sum);
        
        double p1 = random1 / sum * 100;
        double p2 = random2 / sum * 100;
        double p3 = random3 / sum * 100;
        double p4 = random4 / sum * 100;
        double p5 = random5 / sum * 100;
        
        //System.out.println(p1);
        
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigous background right here:\n");
        System.out.println(dogName + " is:\n");
        
        System.out.println(df1.format(p1) + "% Great Dane");
        System.out.println(df1.format(p2) + "% Poodle");
        System.out.println(df1.format(p3) + "% Shitzu");
        System.out.println(df1.format(p4) + "% Grey Hound");
        System.out.println(df1.format(p5) + "% Black Lab");
        
        double sum2 = p1 + p2 + p3 + p4 + p5;
        
        System.out.println("\nSum total: " + sum2 + "% dog.");
        
        System.out.println("Wow, that's QUITE the dog.");
    }
}
