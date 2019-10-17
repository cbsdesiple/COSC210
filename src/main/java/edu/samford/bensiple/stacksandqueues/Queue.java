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
public interface Queue<T> {
    public void enqueue(T data);
    public T dequeue();
    public T front ();
    public int size ();
    public boolean isEmpty ();
}
