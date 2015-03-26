package chapter2;

import java.util.Scanner;

/**
 * Created by ananthmajumdar on 3/24/15.
 */
public class LightMoreLight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            if (nextLine.trim().equals("0")) {
                return;
            } else {
                long factorCount = 0;

                long n = Long.parseLong(nextLine);
                long c=n;
                if (n != 1) {
                    int currentFactors =0;
                    while(c%2==0){
                        currentFactors+=1;
                        c = c/2;
                    }
                    if(currentFactors!=0){
                        if(factorCount==0){
                            factorCount = (currentFactors+1);
                        } else{
                            factorCount = factorCount*(currentFactors+1);
                        }

                        currentFactors = 0;
                    }
                    long i = 3;
                    while(i <= c) {

                        if(c%i==0){
                               currentFactors+=1;
                            c = c/i;
                        } else{
                            if(currentFactors!=0){

                                if(factorCount==0){
                                    factorCount = (currentFactors+1);
                                } else{
                                    factorCount = factorCount*(currentFactors+1);
                                }

                                currentFactors = 0;
                            }
                              i = i+2;
                        }
                    }
                    if(currentFactors!=0){

                        if(factorCount==0){
                            factorCount = (currentFactors+1);
                        } else{
                            factorCount = factorCount*(currentFactors+1);
                        }

                        currentFactors = 0;
                    }

                }

                if(n==1){
                    factorCount =1; // only 1 is the factor for 1
                }


               // System.out.println("factorCount:"+factorCount);

                if (factorCount % 2 == 0) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }

            }
        }

    }
}
