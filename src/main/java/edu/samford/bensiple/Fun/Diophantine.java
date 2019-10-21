
/**
 * Attempt to solve the Diophnatine equation for the supplied integer
 */
package edu.samford.bensiple.Fun;
import java.util.Scanner;
        
/**
 *
 * @author desip
 */
public class Diophantine {
    public static void main (String[] args0){
        System.out.println("Please enter the number  you would like to solve (1-100).");
        Scanner stdin = new Scanner(System.in);
        int num = stdin.nextInt();
        for (long x =-10000; x<=10000; x++) 
            for (long y = -10000; y <=10000; y++)
                for (long z = -10000; z <= 10000; z++)
                    if (x*x*x + y*y*y + z*z*z == num){
                        System.out.printf("Found soultion: x=%d, y=%d, z=%d", x, y, z);
                        System.exit(0);
                    }
            
            
        System.out.println("Cannot find Solution using our limited range");
    }
    
}
