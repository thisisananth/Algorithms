

/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
			List<String> expenses = null;
			while (scanner.hasNext()) {
				
				
				int numItems = scanner.nextInt();
			
				
				if(numItems!=0){
					expenses = new ArrayList<String>();
					for(int i=0;i<numItems;i++){
						expenses.add(scanner.next());
					}
				int totalExchangedCents = calculateTotalExchange(expenses);
				if(totalExchangedCents%100 < 10){
					System.out.println("$"+totalExchangedCents/100+"."+"0"+totalExchangedCents%100);
				}else{
					System.out.println("$"+totalExchangedCents/100+"."+totalExchangedCents%100);
				}
					
				
				}else{
					return;
				}
				
				

			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

	

	}

	// You can insert more classes here if you want.


	public static int calculateTotalExchange(List<String> expenses){
		
		long totalCents = 0;
		int[] centArray = new int[expenses.size()];
		for(int i=0;i<expenses.size();i++){
			String expense = expenses.get(i);
			String[] dollarsAndCents = expense.split("\\.");
			int cents = Integer.valueOf(dollarsAndCents[0])*100;
			if(dollarsAndCents.length >1){
				cents = cents + Integer.valueOf(dollarsAndCents[1]);
			}
			centArray[i] = cents;
			totalCents +=cents;
		}
		
		double average = Math.round((double)totalCents/expenses.size());
		
		
		int totalTaken = 0;
		int totalGiven = 0;
		
		for(int i=0;i<centArray.length;i++){
			
			if(centArray[i]<average){
				totalTaken += average - centArray[i];
			}else if(centArray[i]>average){
				totalGiven += centArray[i] - average;
			}
		}
		
		return  totalTaken > totalGiven ? totalGiven : totalTaken;
		
			
		
		}
	
	
}
