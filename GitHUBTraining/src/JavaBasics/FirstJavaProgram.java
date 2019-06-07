package JavaBasics;

import java.util.Scanner;

public class FirstJavaProgram {

	static String hungry = "Yes";
	static String getValue;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("Do you hungry..?");
		Scanner input = new Scanner(System.in);
		getValue = input.nextLine();

		if (getValue.equals("Yes") || getValue.equals("Y") || getValue.equals("y")) {
			System.out.println("Eat Somthing.!");
		} else {
			System.out.println("Do Work.!");
		}
	}
}
