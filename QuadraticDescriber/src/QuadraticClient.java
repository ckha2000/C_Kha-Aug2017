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
			System.out.println();
			
			System.out.print("a: ");
			double a = userInput.nextDouble();
			
			System.out.print("b: ");
			double b = userInput.nextDouble();
			
			System.out.print("c: ");
			double c = userInput.nextDouble();
			
			System.out.println();
			System.out.println("Description of the graph of:");
			System.out.println("y = " + a + " x^2 + " + b + " x + " + c);
			
			System.out.println(Quadratic.quadrDescriber(a,b,c));
			
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String quit = userInput.next();
			
			System.out.println();
			if(quit.charAt(0) == 'q' || quit.charAt(0) == 'Q') {
				done = true;
			}
		}
		
		userInput.close();

	}

}
