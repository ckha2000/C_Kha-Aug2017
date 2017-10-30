//Christopher Kha Period 2
//October 30, 2017
//This program is for experimenting with the differences between value types and reference types

public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain ="APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		changeMe(num, strMain, arrMain);
	
		System.out.println();
	}

	public static void changeMe(int x, String str, int[] arr) {
		x = 100;
		str = "I love CS";
		arr[0] = 142;
		arr[3] = 543;
	}
}
