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
                long n = Long.parseLong(nextLine);
                if(Math.floor(Math.sqrt(n))==Math.ceil(Math.sqrt(n))){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }
        }

    }
}
