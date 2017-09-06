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
	public static String toImproperFrac(int num1, int num2, int num3) {
		int numerator = num1 * num3 + num2;
		return numerator + "/" + num3;
	}
	
	
	
	
	public static String toMixedNum(int num1, int num2) {
		
	}
		
}
