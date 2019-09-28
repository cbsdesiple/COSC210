package edu.samford.bensiple.lists;
import java.util.ArrayList;
/**
 *
 * @author desip
 */
public class TestDLinkedList {

    public static void main(String[] args) {
        DLinkedList<String> list = new DLinkedList<>();
        DLinkedList<Integer> ratings = new DLinkedList<>();
        ArrayList<Double> area = new ArrayList<>();
    //test an empty list
        System.out.println("Size == 0: " + list.size());
        System.out.println("toString == " + list.toString());
        System.out.println("Size == 0: " + ratings.size());
        System.out.println("toString == " + ratings.toString());
        System.out.println("Size == 0: " + area.size());
        System.out.println("toString == " + area.toString());


        //test a 1 item list
        long starttime = System.nanoTime();
        list.insertFirst("BHM");
        long finishtime = System.nanoTime();
        System.out.println("instert first - one item list " + (finishtime - starttime));
        
        ratings.insertFirst(10);
        area.add(0,3.2);
        System.out.println("Size == 1: " + list.size());
        System.out.println("toString =='BHM': " + list.toString());
        System.out.println("Size == 1: " + ratings.size());
        System.out.println("toString =='10': " + ratings.toString());
        System.out.println("Size == 1: " + area.size());
        System.out.println("toString =='3.2': " + area.toString());
        

        //test a 2 item list
        list.insertLast("ATL");
        ratings.insertLast(7);
        area.add(6.4);
        System.out.println("Size == 2           : " + list.size());
        System.out.println("toString =='BHM,ATL': " + list);
        System.out.println("Size == 2           : " + ratings.size());
        System.out.println("toString =='10,7' : " + ratings);
        System.out.println("Size == 2           : " + area.size());
        System.out.println("toString =='3.2,6.4' : " + area);

    }
}
