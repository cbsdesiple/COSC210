package edu.samford.bensiple.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author desip
 */
public class PerformanceComparison {

    public static final int MAX = 1_000_000;

    public static void main(String[] args) throws FileNotFoundException {
        //0. Set aside a couple longs for instrumentation
        long start = 0;
        long finish = 0;
        long arraytime = 0;
        long listtime = 0;
        //1. Generate a lot of data
        generateData();
        //2. Prepare Output for Excel

        System.out.println("Operation, Array, Linked List");

        //3. start measuring Construction First
        start = System.currentTimeMillis();
        double nums[] = new double[MAX];
        finish = System.currentTimeMillis();
        arraytime = finish - start;
        start = System.currentTimeMillis();
        DLinkedList<Double> numlist = new DLinkedList<>();
        finish = System.currentTimeMillis();
        listtime = finish - start;
        System.out.println("Contruction" + "," + arraytime + "," + listtime);

        //Populating the entire data structure
        File f = new File("randomnums.txt");
        Scanner filein = new Scanner(f);
        int i = 0;
        arraytime = 0;
        listtime = 0;
        while (filein.hasNextDouble()) {
            double d = filein.nextDouble();
            start = System.nanoTime();
            numlist.insertLast(d);
            finish = System.nanoTime();
            listtime += finish - start;
            start = System.nanoTime();
            nums[i++] = d;
            finish = System.nanoTime();
            arraytime += finish - start;
        }
        System.out.println("Populate" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

        //Insterting an item at the beginning of each data structure
        double newitem = Math.random();
        start = System.nanoTime();
        numlist.insertFirst(newitem);
        finish = System.nanoTime();
        listtime = finish - start;
        start = System.nanoTime();
        double tmp[] = new double[nums.length + 1];
        for (int j = 1; j < tmp.length; j++) {
            tmp[j] = nums[j - 1];
        }
        nums = tmp;
        nums[0] = newitem;
        finish = System.nanoTime();
        arraytime = finish - start;
        System.out.println("Insert Beginning" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

        //Inserting an Item in the middle of each data stucture
        newitem = Math.random();
        start = System.nanoTime();
        tmp = new double[nums.length + 1];
        for (int k = 0; k < tmp.length / 2; k++) {
            tmp[k] = nums[k];

        }
        for (int j = 1 + tmp.length / 2; j < tmp.length; j++) {
            tmp[j] = nums[j - 1];
        }
        nums = tmp;
        nums[nums.length / 2] = newitem;
        finish = System.nanoTime();
        arraytime = finish - start;

        start = System.nanoTime();
        int middle = numlist.size() / 2;
        DNode cur = numlist.first();
        i = 0;
        while (i < middle) {
            cur = cur.getNext();
            i++;
        }
        numlist.insertAfter(cur, newitem);
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("Insert Middle" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

        //Insert and Item at the end of the data structure
        newitem = Math.random();
        start = System.nanoTime();
        tmp = new double[nums.length + 1];
        for (int k = 0; k < nums.length; k++) {
            tmp[k] = nums[k];
        }
        nums = tmp;
        nums[nums.length - 1] = newitem;
        finish = System.nanoTime();
        arraytime = finish - start;

        start = System.nanoTime();
        numlist.insertLast(newitem);
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("Insert End" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

        //Removing Items from the beginning of the data structure
        start = System.nanoTime();
        tmp = new double[nums.length - 1];
        for (int k = 0; k < tmp.length; k++) {
            tmp[k] = nums[k + 1];
        }
        nums = tmp;
        finish = System.nanoTime();
        arraytime = finish - start;

        start = System.nanoTime();
        numlist.remove(numlist.first());
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("Remove First" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

//Removing an item from the middle of the data structure
        start = System.nanoTime();
        tmp = new double[nums.length - 1];
        for (int k = 0; k < nums.length / 2; k++) {
            tmp[k] = nums[k];

        }
        for (int j = nums.length / 2 + 1 ; j < tmp.length; j++) {
            tmp[j] = nums[j - 1];
        }
        nums = tmp;
        finish = System.nanoTime();
        arraytime = finish - start;
        
        start = System.nanoTime();
        middle = numlist.size() / 2;
        cur = numlist.first();
        i = 0;
        while (i < middle) {
            cur = cur.getNext();
            i++;
        }
        numlist.remove(cur);
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("Remove Middle" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);
        
        //Remove from End of the data Structure
        start = System.nanoTime();
        tmp = new double[nums.length - 1];
        for (int k = 0; k < tmp.length; k++) {
            tmp[k] = nums[k];
        }
        nums = tmp;
        finish = System.nanoTime();
        arraytime = finish - start;

        start = System.nanoTime();
        numlist.remove(numlist.last());
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("Remove End" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);
        
        //replacing an the item in the middle of the datastructure
        newitem = Math.random();
        start = System.nanoTime();
        nums[nums.length/2]=newitem;
        finish = System.nanoTime();
        arraytime = finish-start;
        
        start = System.nanoTime();
        middle = numlist.size() / 2;
        cur = numlist.first();
        i = 0;
        while (i < middle) {
            cur = cur.getNext();
            i++;
        }
        numlist.replace(cur, newitem);
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("Replace Middle" + "," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

        
    }

    private static void generateData() throws FileNotFoundException {
        File f = new File("randomnums.txt");
        PrintWriter out = new PrintWriter(f);
        for (int i = 0; i < MAX; i++) {
            out.println(Math.random());
        }
        out.close();
    }

}
