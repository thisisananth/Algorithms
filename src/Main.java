/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{
    public void run(){

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

    // You can insert more classes here if you want.
}