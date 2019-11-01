/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.stacksandqueues;

import edu.samford.bensiple.lists.DLinkedList;

/**
 *
 * @author desip
 */
public class ListQueue <T> implements Queue<T>{
    //underlying data structure that stores all of the queue items.  
    //the "front" of the Linked List will be the "front" of the queue.
    //the "end" of the Linked List will be the "back" of the queue.
    protected DLinkedList<T> theQueue = new DLinkedList<>();
    
    
    @Override
    public void enqueue(T data) {
        theQueue.insertLast(data);
    }

    @Override
    public T dequeue() {
        if (theQueue.isEmpty()){
            throw new Error ("You aren't supposed to call dequeue on an empty queue.  Did you check to see if the queue is empty???");
        }
        T data = theQueue.first().element();
        theQueue.remove(theQueue.first());
        return data;
    }

    @Override
    public T front() {
        if (theQueue.isEmpty()){
            throw new Error ("You aren't supposed to call front on an empty queue.  Did you check to see if the queue is empty???");
        }
        T data = theQueue.first().element();
        return data;
    }

    @Override
    public int size() {
        return theQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    @Override
    public String toString() {
        String strval = theQueue.toString();
        return strval;
    }
    
}
