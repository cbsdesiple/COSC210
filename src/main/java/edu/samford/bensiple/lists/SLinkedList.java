
package edu.samford.bensiple.lists;

/**
 *
 * @author desip
 * @param <T>
 */
public class SLinkedList <T>{
    protected int size;
    protected SNode head;
    protected SNode tail;

public SLinkedList (){
    size = 0;
    head = null;
    tail = null;
}

public void addfirst (SNode<T> newnode){
    //first before we forget increment the size
    size++;
    //Now, Order matters
    newnode.setNext(head);
    //Update the head reference to the newly added node
    head = newnode;
    if (size == 1){
        tail = newnode;
    }
}
 
public SNode<T> addfirst  (T newdata){
    SNode<T> newnode = new SNode<>(newdata, null);
    addfirst(newnode);
    return newnode;
            
}
public void addlast (SNode<T> newnode){
    //first before we forget increment the size
    size++;
    
    tail.setNext(newnode);
    
    //Update the head reference to the newly added node
    tail = newnode;
    
    //lastly, do something with the tail
    if (size == 1){
        head = newnode;
    }
}
 
public SNode<T> addlast  (T newdata){
    SNode<T> newnode = new SNode<>(newdata, null);
    addlast(newnode);
    return newnode;
            
}

/**
 * Adds a new node to our list after the position node.
 * @param pos
 * @param newnode 
 */
public void addAfter (SNode<T> pos, SNode<T> newnode){
    size++;
    newnode.setNext(pos.getNext());
    pos.setNext(newnode);
    if (pos == tail){
        tail = newnode;
    }
}

public SNode addAfter (SNode<T> pos, T newdata){
    SNode<T> newnode = new SNode<> (newdata, null);
    addAfter (pos, newnode);
    return newnode;
}
/**
 * searches the entire linked this searchdata is found and returns the node containing the data or null
 * @param searchdata
 * @return 
 */
public SNode<T> find (T searchdata){
    SNode<T> cur = head;
    while (cur!=null){
        if (cur.element().equals(searchdata)){
            return cur;
        }
        cur = cur.getNext();
    }
    return null;
}   

public SNode<T> remove (T searchdata){
    SNode<T> doomed = find(searchdata);
    if (doomed!=null){    
        remove(doomed);
    }
    return doomed;
}


public int size(){
    return size;
}

public boolean isEmpty(){
    return size == 0;
}
@Override
public String toString(){
    String out = "";
    SNode<T> cur = head;
    while (cur!=null){
        out += cur.element();
        cur = cur.getNext();
        if (cur!=null){
            out += ",";
        }
    }
    return out;
}

    private void remove(SNode<T> doomed) {
        
    }



}
