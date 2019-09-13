/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.text;

/**
 *
 * @author desip
 */
public class TextBarChart {
    //Attributes
    protected String labels[];
    protected double values[];
    protected int numrows;
    //Constructor
    
    /**
     * Displays the chart using the populated lables and values
     * 
     */
    
    public void display(){
        
    }
    
    public void addRow (String label, float value){
        labels[numrows] = label;
        values[numrows] = value; 
    }
            
}
