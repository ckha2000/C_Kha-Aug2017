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
	public static double round2(double num){
		double dec3 = num % .01;	//returns everything after the second decimal place
		num -= dec3;			//cuts of everything after the second decimal place
		
		if (absValue(dec3) >= 0.005 ){	//checks to see if rounding is needed
			if(num < 0){	//if num is negative
				num -= 0.01;
			}else{			//if num is positive
				num += 0.01;
			}
		}
		return num;
	}
}
