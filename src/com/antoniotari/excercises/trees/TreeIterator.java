package com.antoniotari.excercises.trees;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<TreeNode>{ 
	private Stack <TreeNode> stackA=new Stack<>(); 

	public TreeIterator(TreeNode root){
		TreeNode treeNode=root;
		while (treeNode!=null){ 
			stackA.push(treeNode); 
			treeNode = treeNode.left; 
		} 

//		for(TreeNode node:stackA){
//			System.out.println(node.val);
//		}
//		System.out.println("\n\n");

	} 

	private TreeNode getNext(){ 
		if (stackA.empty()) return null; 
		TreeNode target = stackA.pop(); // stackA.firstElement();
		TreeNode node = target.right; 
		while (node!=null){ 
			stackA.push(node); 
			node = node.left; 
		} 
		return target; 
	} 

	public void inOrder(TreeNode root) {
		if(root !=  null) {
			inOrder(root.left);
			//Visit the node by Printing the node data  
			System.out.printf("%d ",root.val);
			inOrder(root.right);
		}
	}

	
	@Override
	public boolean hasNext() {
		return !stackA.empty();
	}

	@Override
	public TreeNode next() {
		return getNext();
	}
}