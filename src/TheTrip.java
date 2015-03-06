import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class TheTrip {

	
	public static void main(String[] args) {

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
