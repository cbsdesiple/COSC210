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
public interface Tree <T> {
    public TreeNode<T> root();
    public TreeNode<T> parent(TreeNode<T> node);
    public TreeNode<T>[] children (TreeNode<T> node);
    public int size ();
    public int height ();
    public boolean isEmpty ();
    public int depth (TreeNode<T> node);
    public boolean ancestor (TreeNode<T> node, TreeNode<T> ancestornode); //returns true if anscestornode is in fact an ancestor of node
    public boolean descendant (TreeNode<T> node, TreeNode<T> descendantnode); //returns true if descendantnode is in fact an descendant of node
    public TreeNode<T> search(T searchdata);
    
}
