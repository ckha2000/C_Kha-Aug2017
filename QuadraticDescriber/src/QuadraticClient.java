//Christopher Kha
//October 6, 2017
//Takes in the coefficients of a quadratic equation and prints out a description of it.

import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c");
		
		while(!done) {
			System.out.print("a: ");
			double a = userInput.nextDouble();
			
			System.out.print("b: ");
			double b = userInput.nextDouble();
			
			System.out.print("c: ");
			double c = userInput.nextDouble();
			
			
		}

	}

}
