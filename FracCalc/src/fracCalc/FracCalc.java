//Christopher Kha	Period 2
//November 8, 2017

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	
    	while(true) {
    		if(userInput.nextLine().equals("quit")) {
    			break;
    		}
    		produceAnswer(userInput.nextLine());
    		
    	}
    	
    	userInput.close();
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String[] splitInput = input.split(" ");
        String operand1 = splitInput[0];
        String operand2 = splitInput[2];
        String operator = splitInput[1];
    	
        String op1Components = splitFrac(operand1);
        String op2Components = splitFrac(operand2);
        
        
        
        return op2Components;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String splitFrac(String fraction) {
    	String whole = "0";
    	String num = "0";
    	String denom = "1";
    	
    	int undScoreIndex = fraction.indexOf('_');
    	int fractionIndex = fraction.indexOf('/');
    	
    	if(undScoreIndex > 0){
    		whole = fraction.substring(0, undScoreIndex);
    	}
    	if(fractionIndex > 0){
    		num = fraction.substring(undScoreIndex + 1, fractionIndex);
    		denom = fraction.substring(fractionIndex+1);
    	}else{
    		whole = fraction;
    	}
    	
    	return "whole:" + whole + " numerator:" + num + " denominator:" + denom;
    }
    
    public static String toImproperFrac(int wholeNum, int num, int denom) {
		int numerator = wholeNum * denom + num;
		return numerator + "/" + denom; 
    }
} 
