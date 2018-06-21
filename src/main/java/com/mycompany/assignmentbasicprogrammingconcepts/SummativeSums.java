package com.mycompany.assignmentbasicprogrammingconcepts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcmu0
 */
public class SummativeSums {
    public static void main(String[] args) {
        int array1[] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int array2[] = {999, -60, -77, 14, 160, 301};
        int array3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99} ;
        
        int result1 = sumArray(array1);
        System.out.println("#1 Array Sum: " + result1);
        
        int result2 = sumArray(array2);
        System.out.println("#2 Array Sum: " + result2);
        
        int result3 = sumArray(array3);
        System.out.println("#3 Array Sum: " + result3);
        
    }
    
    public static int sumArray(int array[]) {
        int sum = 0;
        
        for (int num : array) {
            sum += num;
        }
        
        return sum;
    }
    
}
