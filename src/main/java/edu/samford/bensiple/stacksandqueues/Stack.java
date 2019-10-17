/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.stacksandqueues;

/**
 *  push - add to the top of the stack
 * pop - remove the top of the stack and return it
 * top - return the item on top of the stack
 * isEmpty - return true or false whether the stack is empty
 * size - return the number of items in the stack
 * @author desip
 */
public interface Stack<T> {
    public void push (T data);
    public T pop ();
    public T top ();
    public int size();
    public boolean isEmpty();
}
