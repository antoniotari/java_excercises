package com.antoniotari.facebook.treeiterator;

import java.util.Iterator;

public class TreeNode implements Iterable<TreeNode>{
    public int val; 
    public TreeNode left; 
    public TreeNode right;
    
    public TreeNode(int val){
    	this.val=val;
    }

    
	@Override
	public Iterator<TreeNode> iterator() {
        return new TreeIterator(this);
	} 
}
