package qaTest;

/*
 * This code is checking is number is Prime or not.
 * A prime number is a natural number greater than 1 that has no positive divisors 
 * other than 1 and itself.
 */

import java.util.Scanner;

public class PrimeNumber { // open class
	static boolean isPrimeNumber(int setNumber) { // this method takes int for
													// input and boolean for
													// output
		if (setNumber == 1)
			return false; // 1 is incorrect result
		if (setNumber == 2)
			return true; // 2 is correct result
		if (setNumber % 2 == 0)
			return false; // all even numbers are incorrect result
		for (int i = 2; i < setNumber; i++) {
			if (setNumber % i == 0)
				return false;
		} // for loop end
		return true;
	} // method end

	void inputNumber() { // open method
		System.out.printf("Please, enter any number: "); // printout massage for
															// input
		Scanner scr = new Scanner(System.in); // open Scanner class
		while (!scr.hasNextInt()) { // if input is not a digit
			System.err.printf("This is not a number!!!%nTry again: "); // print
																		// error
																		// massage
			scr.next(); // let user enter next attempt
		} // while loop end
		int inputNumber = scr.nextInt(); // assign input for variable
		scr.close(); // close Scanner class
		System.out.printf("The number \"%s\" is %s number;%n", inputNumber, // printout
																			// the
																			// result
				isPrimeNumber(inputNumber) ? "Prime" : "not Prime");

	} // end method

	public static void main(String[] args) { // main method open
		new PrimeNumber().inputNumber();

	} // main method close

} // class close
