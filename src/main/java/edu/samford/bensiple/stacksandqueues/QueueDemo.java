/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.stacksandqueues;

/**
 *
 * @author desip
 */
public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> helpQueue = new ListQueue<>();
        helpQueue.enqueue("Lauren");
        helpQueue.enqueue("Ty");
        System.out.println(helpQueue.dequeue());
        System.out.println(helpQueue.size());
        System.out.println(helpQueue.isEmpty());
        helpQueue.enqueue("Will");
        System.out.println(helpQueue.dequeue());
        System.out.println(helpQueue.size());
        System.out.println(helpQueue.isEmpty());
        System.out.println(helpQueue.dequeue());
        
        // This will crash the program
        //System.out.println(helpQueue.dequeue());
        
    }
}
