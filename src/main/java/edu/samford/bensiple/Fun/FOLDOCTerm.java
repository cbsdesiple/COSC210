/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.Fun;

/**
 *
 * @author desip
 */
public class FOLDOCTerm implements Comparable{
    //Attributes
    protected String term;// The term being defined
    protected String definition; //The definition
    
    //constructor
    public FOLDOCTerm (String term){
        this.term = term;
    }
    
    public FOLDOCTerm (String term, String definition){
        this.term = term;
        this.definition = definition;
    }
    
    public void setDefinition (String definition){
        this.definition = definition;
    }
    
    public String getDefinition (){
        return definition;
    }
    
    public String toString (){
        return term + "-" + definition.length();
    }

    @Override
    public int compareTo(Object o) {
        FOLDOCTerm other = (FOLDOCTerm) o;
        return this.term.compareTo(other.term);
    }
    
    
}
