/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.trees;

/**
 *
 * @author desip
 */
public interface TreeNode<T> {
    public T element();//returns refence to the data we are storing
    public TreeNode <T> parent ();//returns reference to the parent node
    public TreeNode <T>[] children();//returns reference to all children
    public boolean isLeaf();//returns true if this is a leaf
}
