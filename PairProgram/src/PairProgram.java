//Christopher Kha - Period 2
//Pair Program 
//October 4, 2017
//This is a code that takes a string of integers from a scanner and returns the lowest
//highest, sum of evens and largest even numbers

import java.util.*;
public class PairProgram {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		int value;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;	
		int sum = 0;
		int largestEven = Integer.MIN_VALUE;
		
		boolean done = false;
		
		while(!done) {
			System.out.println("How many integers do you have? ");
			int numIntegers = userInput.nextInt();
			System.out.println("Enter a string of integers: ");
			
			for(int i = 0; i < numIntegers; i++) {
				value = userInput.nextInt();
				if(value % 2 == 0) {
					sum = sum + value;
					if(value > largestEven) {
						largestEven = value;
					}
				}
				if(value < min) {
					min = value;
				}else if(value > max) {
					max = value;
				}
			}
			
			System.out.println("Are you done? "); //does not check
			String finished = userInput.nextLine();
			
			if(finished.equalsIgnoreCase("yes")) {
				done = true;
			}
		}
		
		System.out.println("The smallest integer entered is " + min + ".");
		System.out.println("The largest integer entered is " + max + ".");
		
		if(sum == 0 && largestEven == Integer.MIN_VALUE) {
			System.out.println("There are no evens");
		}else {
			System.out.println("The sum of all even integers entered is " + sum + ".");
			System.out.println("The largest even integer entered is " + largestEven + ".");
		}
		
		userInput.close();
	}
}