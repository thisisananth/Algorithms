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
            if(nextLine.trim().equals("0 0")){
                return;
            }else{
                String[] numbers = nextLine.split(" ");
                long num1 = Long.parseLong(numbers[0]);
                long num2 = Long.parseLong(numbers[1]);

                int carryCount = 0;
                int currentCarry = 0;
                long rem1 = 0;
                long rem2 = 0;
                long quot1 = num1;
                long quot2 = num2;


                while(true){
                    /*System.out.println("quot1:"+quot1);
                    System.out.println("quot2:"+quot2);
                    System.out.println("rem1:"+rem1);
                    System.out.println("rem2:"+rem2);
                    System.out.println("carryCount:"+carryCount);
                    System.out.println("currentCarry:"+currentCarry);*/
                    if(quot1!=0 && quot2!=0){
                        rem1 = quot1%10;
                        rem2 = quot2%10;
                        if(rem1+rem2+currentCarry>9){
                               carryCount+=1;
                            currentCarry=1;
                        }else{
                            currentCarry=0;
                        }
                        quot1 = quot1/10;
                        quot2 = quot2/10;
                    }else if(quot2!=0){
                        rem2 = quot2%10;
                        if(rem2+currentCarry>9){
                            carryCount+=1;
                            currentCarry=1;
                        }else{
                            currentCarry=0;
                        }
                        quot2 = quot2/10;
                    }else if(quot1!=0){
                        rem1 = quot1%10;
                        if(rem1+currentCarry>9){
                            carryCount+=1;
                            currentCarry=1;
                        }else{
                            currentCarry=0;
                        }
                        quot1 = quot1/10;
                    }else{
                        break;
                    }
                }


                if(carryCount ==0){
                    System.out.println("No carry operation.");
                }else if(carryCount ==1){
                    System.out.println("1 carry operation.");
                }else{
                    System.out.println(String.format("%d carry operations.",carryCount));
                }

            }
        }

    }
}
