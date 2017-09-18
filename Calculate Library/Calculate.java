/*Christopher Kha
 *September 6, 2017 
 *Our self written math library. 
 *It contains a series of methods to do basic math functions.
 */
public class Calculate {
	
	//square the input
	public static int square(int operand) {
		return operand*operand;
	}
	
	//cube the input
	public static int cube(int operand) {
		return operand*operand*operand;
	}
	
	//averages two doubles
	public static double average(double num1, double num2) {
		return (num1+num2)/2;
	}
	
	//averages three doubles
	public static double average(double num1, double num2, double num3) {
		return (num1+num2+num3)/3;
	}
	
	//converts an angle from radians to degrees
	public static double toDegrees(double theta) {
		return theta*(180/3.14159);
	}
	
	//converts an angle from degrees to radians
	public static double toRadians(double theta) {
		return theta*(3.14159/180);
	}
	
	//calculates the discriminant of a given quadratic equation
	public static double discriminant(double a, double b, double c) {
		return b*b - 4*a*c;
	}
	
	//takes a mixed number and converts it into an improper fraction
	public static String toImproperFrac(int wholeNum, int num, int denom) {
		int numerator = wholeNum * denom + num;
		return numerator + "/" + denom;
	}
	
	//takes an improper fraction and converts it into a mixed number
	public static String toMixedNum(int num, int denom) {
		int wholeNum = num / denom;
		int numerator = num % denom;
		if (numerator==0){
			return Integer.toString(wholeNum);
		}else{
			return wholeNum + "_" + numerator + "/" + denom;
		}
	}
	
	// takes a binomial expression in the form (ax + b)(cx + d) and 
	//returns it in the quadratic form  Ax^2 + Bx + C
	public static String foil(int a, int b, int c, int d, String x) {
		int A = a*c;
		int B = a*d + b*c;
		int C = b*d;
		
		//A
		String equation = A + x + "^2";
		
		//B
		if(B>0){	//B is positive
			equation += " + " + B + x;
		}else if(B<0){		//B is negative
			equation += " - " + B + x;
		}
		
		//C
		if(C>0){	//C is positive
			equation += " + " + C;
		}else if(C<0){	//C is negative
			equation += " - " + (-1)*C;
		}
				
		return equation; 
	}
	
	//determines if the first integer is divisible by the second integer
	public static boolean isDivisibleBy(int num, int denom) {
		int remainder = num % denom;
		return (remainder == 0);
	}
	
	//returns the absolute value of a given double
	public static double absValue(double number){
		if(number < 0){
			return number*-1;
		}else{
			return number;
		}
	}
	
	//returns the larger of the two numbers passed into it
	public static double max(double num1, double num2){
		if(num1 >= num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	//returns the largest of the three numbers passed into it
	public static double max(double num1, double num2, double num3){
		if(num1 > num2 && num1 > num3){
			return num1;
		}else if(num2 > num3){
			return num2;
		}else{
			return num3;
		}
	}
	
	//returns the smaller of the two numbers passed into it
	public static double min(double num1, double num2){
		if(num1 < num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	//rounds any decimal number to two decimal places
	public static double round2(double orig){
		double result = 0.0;
		
		int tempInt = (int) (orig = 1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt/10;
		if(roundNum >=0 && tempInt > 0) {
			tempInt++;
		}else if(roundNum <= -5 && tempInt < 0) {
			tempInt--;
		}
		result = tempInt/100.0;
		return result;
	}
	
	//takes in an exponent expression and returns the result as a double
	public static double exponent(double base, int exponent) {
		double resultant = 1;
		for(int i = 0; i < exponent; i++) {
			resultant *= base;
		}
		return resultant;
	}
	
	//takes in a positive integer and returns its expanded factorial
	public static int factorial(int num){
		int resultant = 1;
		while(num > 1){
			resultant *= num;
			num--;
		}
		return resultant;
	}
	
	//checks if the input is a prime number
	public static boolean isPrime(int num){
		int n = (int)absValue(num);
		int factor = n - 1;
		boolean isPrime = true;
		while(factor > 2){
			if(isDivisibleBy(n, factor)){
				isPrime = false;
				break;
			}
			factor--;
		}
		return isPrime;
	}
	
	//returns the greatest common factor of two integers
	public static int gcf(int a, int b){
		int divisor = 0;
	    if(a < 0){
	        a *= -1;
	    }
	    if(b < 0){
	        b *= -1;
	    }
	    
	    if(b > a){
	        divisor = b;
	    }else{
	        divisor = a;
	    }
	    
	    while (divisor >= 1){
	        if(a % divisor == b % divisor && a % divisor ==0){
	            break;
	        }
	        divisor--;
	    }
	    return divisor;
	}
	
	//returns the square root of a decimal number rounded to the nearest two decimal places
	public static double sqrt(double num){
		if(num < 0){
			throw new IllegalArgumentException("Negative number: " + num);
		}
		
		double guess = 1;
		double difference;
		
		if(num == 0 || num == 1){
			return num;
		}
			
		while(true){
			guess = .5*(num/guess + guess);
			difference = guess*guess - num;
			if(absValue(difference) <= 0.005){
				return round2(guess);
			}
			if(difference > 0){
				guess +=0.001;
			}else if(difference < 0){
				guess -= 0.001;
			}
		}
	}	
}
