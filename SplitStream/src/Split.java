import java.util.Arrays;

//Christopher Kha
//October 

public class Split {

	public static void main(String[] args) {
		// Part 0
		
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//	it will split at spaces and return an array of ["I","like","apples!"]
		printSplit("I like apples!", " ");
		
		// Example 2: "I really like really red apples".split("really")
		//	it will split at the word "really" and return an array of ["I "," like "," red apples!"]
		//play around with String.split! 
		printSplit("I really like really red apples", "really");
		//What happens if you "I reallyreally likeapples".split("really") ?
		
		printSplit("I reallyreally like apples really", "really");
		printSplit("", "really");
		printSplit("really", "really");
		printSplit("really I", "really");
		
		System.out.println();
		
		//part 1
		printFilling("applespineapplesbreadlettustomatobaconmayohambreadcheese");
		printFilling("bread");
		printFilling("");
		printFilling("bread mayo bread cheese");
		
		System.out.println();
		
		//part 2
		splitBySpaces("apples pineapples bread lettuc tomato bacon mayo ham bread cheese");
		splitBySpaces("applesoranges pineapples bread lettuce bread bread icecream bread");
		splitBySpaces("bread applesoranges pineapples bread lettuce bread bread icecream bread");
	}
		
	//part 0 - prints out the split array
	public static void printSplit(String message, String splitVar){
		System.out.println(Arrays.toString(message.split(splitVar)));
	}
	
	//part 1 - prints out an array of sandwich fillings split at the loaves of bread
	public static void printFilling(String ingredients){
		System.out.println(Arrays.toString(ingredients.split("bread")));
	}
	
	//part 2 - prints out an array of sandwich fillings split at the spaces
	public static void splitBySpaces(String ingredients){
		String[] temp = ingredients.split(" ");
		int length = 0;
		int fillingCounter = 0;
		
		for(String curr : temp){
			if(!curr.equals("bread")){
				length++;
			}
		}
		String[] filling = new String[length];
		
		
		
		for(int i = 0; i < temp.length; i++){
			if(!temp[i].equals("bread")){
				filling[fillingCounter] = temp[i];
				fillingCounter++;
			}
		}
		System.out.println(Arrays.toString(filling));
	}

}