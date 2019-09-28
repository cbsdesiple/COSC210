package edu.samford.bensiple.lists;

/**
 *
 * @author desip
 */
public class TestSLinkedList {

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<>();
        SLinkedList<Integer> ratings = new SLinkedList<>();
        //test an empty list
        System.out.println("Size == 0: " + list.size);
        System.out.println("toString == " + list.toString());
        System.out.println("Size == 0: " + ratings.size);
        System.out.println("toString == " + ratings.toString());


        //test a 1 item list
        list.addfirst("BHM");
        ratings.addfirst(10);
        System.out.println("Size == 1: " + list.size);
        System.out.println("toString =='BHM': " + list.toString());
        System.out.println("Size == 1: " + ratings.size);
        System.out.println("toString =='10': " + ratings.toString());
        

        //test a 2 item list
        list.addlast("ATL");
        ratings.addlast(7);
        System.out.println("Size == 2           : " + list.size);
        System.out.println("toString =='BHM,ATL': " + list);
        System.out.println("Size == 2           : " + ratings.size);
        System.out.println("toString =='10,ATL' : " + ratings);
        
        SNode<String> bhmnode = list.find("BHM");
        System.out.println(bhmnode.element());
        
    }
}
