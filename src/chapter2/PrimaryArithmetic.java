package chapter2;

import java.util.Scanner;

/**
 * Created by ananthmajumdar on 3/17/15.
 */
public class PrimaryArithmetic {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String nextLine = scanner.nextLine();
            if(nextLine.equals("0 0")){
                return;
            }else{
                String[] numbers = nextLine.split(" ");

                String num1 = new StringBuffer(numbers[0]).reverse().toString();
                String num2 = new StringBuffer(numbers[1]).reverse().toString();

                int carryCount = 0;
                int currentCarry = 0;

                int addableNumbers = Math.min(num1.length(), num2.length());

                for(int i=0;i<addableNumbers;i++){

                    int sum = Integer.valueOf(String.valueOf(num1.charAt(i))).intValue()+Integer.valueOf(String.valueOf(num2.charAt(i))).intValue()+currentCarry;
                    if(sum>=10){
                        carryCount+=1;
                        currentCarry = 1;
                    }

                }

                while(currentCarry==1){
                    if ((num1.length() > addableNumbers && Integer.valueOf(String.valueOf(num1.charAt(addableNumbers))).intValue() == 9) ||
                            (num2.length() > addableNumbers && Integer.valueOf(String.valueOf(num2.charAt(addableNumbers))).intValue()  == 9)) {
                        carryCount+=1;
                        currentCarry =1;
                        addableNumbers++;

                    }else{
                        currentCarry = 0;
                    }
                }

                if(carryCount ==0){
                    System.out.println("No carry operation.");
                }else if(carryCount ==1){
                    System.out.println("1 carry operation.");
                }else{
                    System.out.println(String.format("%d carry operations",carryCount));
                }

            }
        }

    }
}
