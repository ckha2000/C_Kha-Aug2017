//Christopher Kha	Period 2
//October 6, 2017
//performs the calculations for the quadratic describer and returns the results as a string
public class Quadratic {
	//calculates the discriminant of a given quadratic equation
	public static double discriminant(double a, double b, double c) {
		return b*b - 4*a*c; 
	}
	
	//returns the absolute value of a given double
	public static double absValue(double number){
		if(number < 0){
			return number*-1;
		}else{
			return number;
		}
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
	
	//returns the smaller of the two numbers passed into it - overloaded for doubles
	public static double min(double num1, double num2){
		if(num1 < num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	//returns the roots of a quadratic function as a String
	public static String quadForm(double a, double b, double c){
		if(a == 0){
			throw new IllegalArgumentException("Please enter a valid coefficient for \"a\"");
		}
		
		int numRoots;
		double rt1;
		double rt2;
		
		double discrim = discriminant(a, b, c);
		
		if(discrim < 0){ 
			numRoots = 0;
		}else if(discrim == 0){
			numRoots = 1;
		}else{
			numRoots = 2;
		}
		
		if(numRoots == 0){
			return "no real roots";
			
		}else if(numRoots == 1){
			return "" + (-1*b)/(2*a);
			
		}else{ //two roots
			rt1 = round2(((-1*b)+sqrt(discrim))/(2*a));	
			rt2 = round2(((-1*b)-sqrt(discrim))/(2*a));
			
			if(min(rt1, rt2) == rt1){ //returns the lower value first
				return rt1 + " and " + rt2;
			}else{
				return rt2 + " and " + rt1;
			}
		}
	}
	
	//returns a String containing a description of the direction, AOS, vertex, x-int, and y-int of the quadratic equation
	public static String quadrDescriber(double a, double b, double c) {
		String s = "Description of the Graph of:\ny = " + a + " x^2 ";
		
		if(b != 0){
			s += "+ " + b + " x ";
		}
		
		if(c != 0){
			s += "+ " + c;
		}
		
		s+= "\n\n";
		
		String openDirec = "";
		if(a > 0) {
			openDirec = "Up";
		}else {
			openDirec = "Down";
		}
		s += "Opens: " + openDirec;
		
		double AOS = (-1)*b/(2*a);
		s += "\nAxis of Symmetry: " + AOS;
		
		double vertexY = a*AOS*AOS + b*AOS + c;
		s += "\nVertex: (" + AOS + ", " + vertexY + ")";
		
		String xInts = "";
		double discrim = discriminant(a, b, c);
		if(!(discrim  < 0)) {
			xInts = quadForm(a, b, c);
		}else {
			xInts = "None";
		}
		s += "\nx-intercept(s): " + xInts;

		s += "\ny-intercept: " + c;
		
		return	s;	
	}
	
}
 
