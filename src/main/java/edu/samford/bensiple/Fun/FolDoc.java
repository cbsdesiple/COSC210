/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.Fun;

import edu.samford.bensiple.lists.DLinkedList;
import edu.samford.bensiple.trees.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author desip
 */
public class FolDoc {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner filein = new Scanner(new File("Dictionary.txt"));
        String currentTerm = "";
        String currentDefinition = "";
        BST<FOLDOCTerm> bst = new BST<>();
        DLinkedList<FOLDOCTerm> list = new DLinkedList<>();
        while (filein.hasNextLine()) {
            String nextline = filein.nextLine();

            if (nextline.trim().equals("")) {
                //we must have blank line lets add it to the definition
                currentDefinition += "\n";
            } else if (nextline.charAt(0) == '\t') {
                //we must be still going with a defintion
                currentDefinition += nextline.trim() + "\n";
            } else {
                //we must have encountered a new term
                //1. add the old term to the data structure
                if (!currentTerm.equals("")) {
                    FOLDOCTerm newterm = new FOLDOCTerm(currentTerm, currentDefinition);
                    list.insertLast(newterm);
                    bst.add(newterm);
                }
                //2. Add the new term
                currentTerm = nextline.trim();
                //3. Reset the current defintion
                currentDefinition = "";
            }
            //System.out.println(nextline);
        }
        System.out.println("Linked list: " + list.size() + " terms.");
        System.out.println("Binary search tree: " + bst.size() + " terms.");
        Scanner stdin = new Scanner(System.in);
        bst.rebalance();
        while (true) {
            System.out.print("What term would you like to find? ");
            String searchstr = stdin.nextLine();  // retrieves the search term
            if (searchstr.equals("-exit-")) {
                break;   // exit out of the loop because the user must have entered -exit-
            }
            // now perform the search on both data structures, measuring how long it takes
            System.out.println("Searching for: " + searchstr);  // temporary debugging display
            FOLDOCTerm faketerm = new FOLDOCTerm(searchstr, "");
            long start1 = System.nanoTime();
            Object listhit = list.search(faketerm);
            long finish1 = System.nanoTime();
            long duration1 = finish1 - start1;
            long start2 = System.nanoTime();
            Object bsthit = bst.search(faketerm);
            long finish2 = System.nanoTime();
            long duration2 = finish2 - start2;
            System.out.println(listhit + "," + bsthit);
            System.out.println(duration1 + "," + duration2);
        }
    }
}
