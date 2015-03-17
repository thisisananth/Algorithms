package chapter1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThreeNPlusOne {

	public static void main(String[] args) {

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

	public static int maxCycle(int start, int end) {

		int maxCycle = 0;

		int currentValue = start;

		while (currentValue <= end) {
			int currentCycle = getCycle(currentValue);
			if (currentCycle > maxCycle) {
				maxCycle = currentCycle;

			}
			currentValue++;
		}

		return maxCycle;

	}

	public static int getCycle(int num) {

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

		return cycle;
	}
}
