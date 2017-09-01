
public class GPA {
	public static void main(String[] args) {
		double grade1 = 4.0;
		double grade2 = 3.0;
		double grade3 = 2.0;
		
		double gpa = calcGPA(grade1, grade2, grade3);
		printGPA(gpa);
	}
	
	public static void printGPA(double gpa) {
		System.out.println(gpa);
	}
	
	public static double calcGPA(double grade1, double grade2, double grade3) {
		double sum = grade1 + grade2 + grade3;
		double GPA = sum/3;
		
		return GPA;
	}
}
