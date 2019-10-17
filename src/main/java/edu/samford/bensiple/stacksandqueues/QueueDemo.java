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
        Queue <Integer> nums = new ListQueue<>();
        //The Queue is currently empty
        nums.enqueue(1);
        nums.enqueue(2);
        nums.enqueue(3);
        nums.enqueue(4);
        nums.enqueue(5);
        
        System.out.println("Front of Queue:" + nums.front());
        System.out.println("Dequeue: " + nums.dequeue());
        System.out.println("Front of Queue:" + nums.front());
        System.out.println("Dequeue: " + nums.dequeue());
        System.out.println("Front of Queue:" + nums.front());
        System.out.println("Dequeue: " + nums.dequeue());
        System.out.println("Front of Queue:" + nums.front());
        System.out.println("Dequeue: " + nums.dequeue());
        System.out.println("Front of Queue:" + nums.front());
        System.out.println("Dequeue: " + nums.dequeue());
        //This will throw and error
        sSystem.out.println(nums.dequeue());
    }
}
