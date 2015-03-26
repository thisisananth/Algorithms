package chapter2;

import java.util.Scanner;

/**
 * Created by ananthmajumdar on 3/19/15.
 */
public class MultiplicationGame {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            Long n = scanner.nextLong();

            //1-9
            //10-18
            //19-162
            //163-324
            //325 - 2916
            //2917 - 5832
            //
               if(n < 4294967295L) {

                   if(n==1){
                       System.out.println("Stan wins.");
                   }else{
                       double log18 = Math.log10(n)/Math.log10(18);
                       //System.out.println(log18);

                       String log18Str = String.valueOf(log18);
                       String  power18 = log18Str.substring(0,log18Str.indexOf('.'));
                       //System.out.println(power18);

                       Long exactPower = (long) Math.pow(18,Double.parseDouble(power18));
                       //System.out.println(exactPower);


                       if(n>=exactPower+1 && n<=exactPower*9){
                           System.out.println("Stan wins.");
                       }else{
                           System.out.println("Ollie wins.");
                       }
                   }


               }



            //4294967295

        }


    }
}
