package com.gl.quest1;
import java.util.Scanner;
/*
 * Write a program to print nth term in a fibonacci series using recursion where 
 * the first 2 numbers are 0 & 1.
 */
public class Question01 {

	public static int calculateFibonacci(int n) {
	    // Base case: Fibonacci numbers at positions 0 and 1 are 0 and 1, respectively
	    if (n == 0) {
	      return 0;
	    } else if (n == 1) {
	      return 1;
	    }

	    // Recursive case: sum of the previous two Fibonacci numbers
	    return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
	  }

	  public static void main(String[] args) {
	    int term = 0;
	    int fibonacciNumber = calculateFibonacci(term);
	    System.out.println("The Fibonacci number for the Term " + term + " is: " + fibonacciNumber);
	    term = 3;
	    fibonacciNumber = calculateFibonacci(term);
	    System.out.println("\nThe Fibonacci number for the Term " + term + " is: " + fibonacciNumber);
	    term = 9;
	    fibonacciNumber = calculateFibonacci(term);
	    System.out.println("\nThe Fibonacci number for the Term " + term + " is: " + fibonacciNumber);
	    
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Enter the Term for which you need to find the Fibonacci Series ...");
	    term  = scan.nextInt();
	    fibonacciNumber = calculateFibonacci(term);
	    
	    System.out.println("\nThe Fibonacci number for the Term " + term + " is: " + fibonacciNumber);
	  }

}
