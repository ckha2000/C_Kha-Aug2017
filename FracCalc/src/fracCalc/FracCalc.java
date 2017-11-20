//Christopher Kha	Period 2
//November 8, 2017

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	String input = "";
    	
    	while(true) {
    		input = userInput.nextLine();
    		
    		if(input.equals("quit")) {
    			break;
    		}else {
    			System.out.println(produceAnswer(input));	
    		}
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
        int[] answer = new int[3];
    	
    	String[] splitInput = input.split(" ");
        String operand1 = splitInput[0];
        String operand2 = splitInput[2];
        String operator = splitInput[1];
    	
        int[] op1Components = splitFrac(operand1);
        int[] op2Components = splitFrac(operand2);
        
        toImproperFrac(op1Components);
        toImproperFrac(op2Components);
        
        //implement addition and multiplication methods
        if(operator.equals("+") || operator.equals("-")) {
        	answer = addition(op1Components, op2Components, operator);
        }else if(operator.equals("*") || operator.equals("/")) {
        	answer = multiplication(op1Components, op2Components, operator);
        }
        
        if(answer[1] == 0) {
        	return "0";
        }
        
        reduceFraction(answer);
        
        //rewrite return
        if(answer[0] == 0) {
        		return answer[1] + "/" + answer[2]; 
        }else if(answer[1] ==0){ 
        	return answer[0] + "";
        }else {
        	return answer[0] + "_" + answer[1] + "/" + answer[2];
        }
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] splitFrac(String fraction) {
    	int whole = 0;
    	int num = 0;
    	int denom = 1;
    	int[] arr = new int[3];
    	
    	int undScoreIndex = fraction.indexOf('_');
    	int fractionIndex = fraction.indexOf('/');
    	
    	if(undScoreIndex > 0){
    		whole = Integer.valueOf(fraction.substring(0, undScoreIndex));
    	}
    	if(fractionIndex > 0){
    		num = Integer.valueOf(fraction.substring(undScoreIndex + 1, fractionIndex));
    		denom = Integer.valueOf(fraction.substring(fractionIndex+1));
    	}else{
    		whole = Integer.valueOf(fraction);
    	}
    	
    	arr[0] = whole;
    	arr[1] = num;
    	arr[2] = denom;
    	
    	return arr;
    }
    
    public static int[] addition(int[] op1, int[] op2, String operand) {
    	int[] calc = new int[3];
    	
    	toCommonDenom(op1, op2);
    	if(operand.equals("-")) {
    		op2[1] *= -1;
    	}
    	
    	calc[1] = op1[1] + op2[1];
    	calc[2] = op1[2];
    	
    	return calc;
    }
    
    public static int[] multiplication(int[] op1, int[] op2, String operand) {
    	int[] calc = new int[3];
    	
    	//flip num and denom if division
    	if(operand.equals("/")) {
    		int temp = op2[1];
    		op2[1] = op2[2];
    		op2[2] = temp;
    		
    	}
    	
    	calc[1] = op1[1] * op2[1];
    	calc[2] = op1[2] * op2[2];
    	
    	if(calc[1] < 0 && calc [2] < 0) {
    		calc[1] *= -1;
    		calc[2] *= -1;
    	}
    	
    	return calc;
    }
    
    public static void toCommonDenom(int[] op1, int[] op2) {
    	int denom = op1[2] * op2[2];
    	
    	//multiplies each numerator by the opposing denominator
    	op1[1] *= op2[2];
    	op2[1] *= op1[2];
    	
    	//sets the denominators to the common denom
    	op1[2] = denom;
    	op2[2] = denom;
    }
    
    //converts the fraction into an improper fraction where arr[0] is the whole number,
    //arr[1] is the numerator, and arr[2] is the denominator
    public static void toImproperFrac(int[] arr) {
		if(arr[0] < 0) {
			arr[1] *= -1;
		}
    	
    	arr[1] = arr[0] * arr[2] + arr[1];
		arr[0] = 0;
    }
    
    public static int absValue(int number){
		if(number < 0){
			return number*-1;
		}else{
			return number;
		}
	}
    
    public static int gcf(int a, int b){
		int divisor = 0;
	    a = absValue(a); 
	    b = absValue(b);
	    
	    if(b > a){ 	//starts the divisor at the greater value
	        divisor = b;
	    }else{
	        divisor = a;
	    }
	    
	    if(a == 0 || b == 0) { //checks if one of the values is 0
	    	return 0;
	    }
	    while (divisor >= 1){	//runs through every value between the greater number and zero until it reaches a value that is a common factor
	        if(a % divisor == 0 && b % divisor == 0){
	            break;
	        }
	        divisor--;
	    }
	    return divisor;
	}
    
    public static void reduceFraction(int[] arr) {
    	int commonFactor = gcf(arr[1], arr[2]);
    	arr[1] /= commonFactor;
    	arr[2] /= commonFactor;
    	
    	arr[0] = arr[1]/arr[2];
    	if(arr[0] < 0) {
    		arr[1] *= -1;
    	}
    	arr[1] = arr[1] % arr[2];
    }
} 
