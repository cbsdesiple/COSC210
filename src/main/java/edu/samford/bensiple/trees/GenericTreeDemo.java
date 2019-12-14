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
public class GenericTreeDemo {
    public static void main(String[] args) {
        GenericTree<String> airports = new GenericTree<>("BHM");
        TreeNode atlnode = airports.addChild(airports.root(),"ATL");
        airports.addChild(airports.root(),"MSP");
        airports.addChild(atlnode, "BOS");
        airports.addChild(atlnode, "SFO");
        airports.addChild(atlnode, "MCO");
        System.out.println(airports);
        TreeNode<String> xyz = airports.search("XYZ");
        System.out.println(xyz);
    }
}
