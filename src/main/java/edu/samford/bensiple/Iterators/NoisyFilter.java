/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.Iterators;

import edu.samford.bensiple.lists.DLinkedList;
import java.util.Iterator;

/**
 *
 * @author desip
 */
public class NoisyFilter {

    static DLinkedList<Integer> temps = new DLinkedList<>();

    public static void main(String[] args) {
        //declare variables to be used and initalize to 0.
        double percentdif = 0;
        double avg1 = 0;
        double avg2 = 0;
        double noiseprob = .001;//set noise prob to starting vaule of .1%
        //Loop through possible noise probablities until the percent difference is more than 1%
        while (percentdif < .01){
            generateNoisyData(90, 110, noiseprob);
            avg1 = calculateAverage();
            filterNoisyData(90, 110);
            avg2 = calculateAverage();
            System.out.println("Average with Noisy data " + avg1);
            System.out.println("Average without Noisey Data " + avg2);
            percentdif = (avg1-avg2)/avg2;//calculate precent difference            
            if (percentdif >= .01){
                System.out.println("Noisy data must be at least  " + noiseprob * 100 + "% to cause the average to be off by more than 1%.");
                }else noiseprob += .001;
            
        }//end while loop
        
    }

    /**
     * Generate data between low and high unless with 1- noise prob probability
     * otherwise generate some anomolis data
     *
     * @param low
     * @param high
     * @param noiseprob
     */
    private static void generateNoisyData(int low, int high, double noiseprob) {
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < 1000; i++) {
            if (Math.random() < noiseprob) {
                //generate a noisy reading
                temps.insertLast(r.nextInt(2000));
            } else {
                //generate typical AL summer reading
                temps.insertLast(low + r.nextInt(high - low));
            }

        }
    }

    private static double calculateAverage() {
        double total = 0;
        for (Integer temp : temps) {
            total += temp;

        }
        return total / temps.size();

    }

    /**
     * Remove any data outside the expected range
     */
    private static void filterNoisyData(int low, int high) {
        Iterator<Integer> it = temps.iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (temp < low || temp > high) {
                it.remove();
            }
        }
    }

}
