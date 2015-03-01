

/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main implements Runnable {
	static String ReadLn(int maxLength) { // utility function to read from
											// stdin,
											// Provided by
											// Programming-challenges, edit for
											// style only
		byte line[] = new byte[maxLength];
		int length = 0;
		int input = -1;
		try {
			while (length < maxLength) {// Read untill maxlength
				input = System.in.read();
				if ((input < 0) || (input == '\n'))
					break; // or untill end of line ninput
				line[length++] += input;
			}

			if ((input < 0) && (length == 0))
				return null; // eof
			return new String(line, 0, length);
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String args[]) // entry point from OS
	{
		Main myWork = new Main(); // Construct the bootloader
		myWork.run(); // execute
	}

	public void run() {
		new myStuff().run();
	}
}

class myStuff implements Runnable {
	public void run() {
		// Your program here
		Scanner scanner = new Scanner(System.in);

		try {
			while (scanner.hasNext()) {
				int i = scanner.nextInt();
				int j = scanner.nextInt();

				System.out.println(i + " " + j + " "
						+ maxCycle(Math.min(i, j), Math.max(i, j)));

			}
		} catch (InputMismatchException e) {

		}

	}

	// You can insert more classes here if you want.

	public static int maxCycle(int start, int end) {

		int maxCycle = 0;

		int currentValue = start;

		while (currentValue <= end) {
			int currentCycle = getCycle(currentValue);
			if (currentCycle > maxCycle) {
				maxCycle = currentCycle;
				// System.out.println("maxValue:"+currentValue);
			}
			currentValue++;
		}

		// 18 9 28 14 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1

		return maxCycle;

	}

	public static int getCycle(int num) {

		//int[] cycleValue = new int[1000000];

		//if (cycleValue[num - 1] != 0) {
		//	return cycleValue[num - 1];
		//}

		int cycle = 1;

		while (num != 1) {
			if (num % 2 == 0) {
				num = num / 2;
				cycle++;
			} else {
				num = 3 * num + 1;
				cycle++;
			}
		}

		//cycleValue[num - 1] = cycle;

		return cycle;
	}
}
