//Christopher Kha
//October 6, 2017
//performs the calculations for the quadratic describer and returns the results as a string
public class Quadratic {
	
	public static double discriminant(double a, double b, double c) {
		return b*b - 4*a*c; 
	}
	
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
	
	public static String quadrDescriber(double a, double b, double c) {
		String s = "";
		String openDirec = "";
		
		if(a > 0) {
			openDirec = "Up";
		}else {
			openDirec = "Down";
		}
		
		s= s + "Opens: " + openDirec;
		
		
		return	s;	
	}
	
}
 