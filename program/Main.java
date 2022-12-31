package program;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.print("Number of objects to generate (between 1 and 20): ");
			
			int temp = input.nextInt();
			if (temp <= 20 && temp > 0) {
				Panel.numberOfBalls = temp;
				break;
			} else {
				System.out.println("Enter a valid number.");
			}
		}
		
		Frame frame = new Frame();

	}

}
