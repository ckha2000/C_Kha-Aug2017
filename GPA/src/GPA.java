
public class GPA {
	public static void main(String[] args) {
		double score = calcGPA(4.0, 3.5, 4.0);
		System.out.println(score);
	}
	
	public static double calcGPA(double x, double y, double z) {
		double sum = x + y + z;
		double GPA = sum/3;
		return GPA;
	}
}
