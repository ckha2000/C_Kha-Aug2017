/*Christopher Kha - 2nd Period 
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
		if(B>0){			//B is positive
			equation += " + " + B + x;
		}else if(B<0){		//B is negative
			equation += " - " + B + x;
		}
		
		//C
		if(C>0){			//C is positive
			equation += " + " + C;
		}else if(C<0){		//C is negative
			equation += " - " + (-1)*C;
		}
				
		return equation; 
	}
	
	//determines if the first integer is divisible by the second integer
	public static boolean isDivisibleBy(int num, int denom) {
		if(denom == 0){
			throw new IllegalArgumentException("denom cannot be 0"); 
		}
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
	
	public static int absValue(int number){
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
	
	//returns smaller of the two numbers
	public static int min(int num1, int num2) {
		if(num1 < num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	//returns the smaller of the two numbers passed into it - overloaded for doubles
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
		
		int tempInt = (int) (orig * 1000);
		int roundNum = tempInt % 10;	//takes the digit in the 3rd decimal place of the original number
		tempInt = tempInt/10;				
		if(roundNum >=5 && tempInt > 0) { //positive
			tempInt++;
		}else if(roundNum <= -5 && tempInt < 0) { //negative
			tempInt--;
		}
		result = tempInt/100.0;
		return result;
	}
	
	//takes in an exponent expression and returns the result as a double - only computes positive exponents
	public static double exponent(double base, int exponent) {
		if(exponent < 0) {
			throw new IllegalArgumentException("Enter a positive exponent");
		}
		
		double resultant = 1;
		for(int i = 0; i < exponent; i++) {
			resultant *= base;
		}
		return resultant;
	}
	
	//takes in a positive integer and computes its factorial - returns it as an int
	public static int factorial(int num){
		if(num < 0) {
			throw new IllegalArgumentException("The input to factorial cannot be negative");
		}
		int resultant = 1;
		while(num > 1){
			resultant *= num;
			num--;
		}
		return resultant;
	}
	
	//checks if the input is a prime number - returns as a boolean value
	public static boolean isPrime(int num){
		int n = absValue(num);
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
	
	//returns the square root of a decimal number rounded to the nearest two decimal places
	public static double sqrt(double num){
		if(num < 0){
			throw new IllegalArgumentException("You cannot take the square root of a negative number");
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
	
	//returns the roots of a quadratic function as a String
	public static String quadForm(int a, int b, int c){
		if(a <= 0){
			throw new IllegalArgumentException("Please enter a valid coefficient for \"a\"");
		}
		
		int numRoots;
		double rt1;
		double rt2;
		
		double discriminant = discriminant(a, b, c);
		
		if(discriminant < 0){ 
			numRoots = 0;
		}else if(discriminant == 0){
			numRoots = 1;
		}else{
			numRoots = 2;
		}
		
		if(numRoots == 0){
			return "no real roots";
			
		}else if(numRoots == 1){
			return "" + (-1*b)/(2*a);
			
		}else{ //two roots
			rt1 = round2(((-1*b)+sqrt(discriminant))/(2*a));	
			rt2 = round2(((-1*b)-sqrt(discriminant))/(2*a));
			
			if(min(rt1, rt2) == rt1){ //returns the lower value first
				return rt1 + " and " + rt2;
			}else{
				return rt2 + " and " + rt1;
			}
		}
	}
}
