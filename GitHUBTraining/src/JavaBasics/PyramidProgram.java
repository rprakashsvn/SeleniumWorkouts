package JavaBasics;

import java.util.Scanner;

public class PyramidProgram {

	static int maxSize;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("Enter the Maximum Number");
		Scanner input = new Scanner(System.in);
		maxSize = input.nextInt();
		System.out.println("Entered the Maximum Number Is : " + maxSize);

		for (int i = 1; i <= maxSize; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
