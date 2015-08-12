package com.antoniotari.facebook.treeiterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	
	// prints spiral/zigzag level order
	public void spiralOrZigzagLevelOrder() {
		TreeNode root=this;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);

		boolean directionflag=false;
		while(!stack.isEmpty()){
			Stack<TreeNode> tempStack=new Stack<TreeNode>();
			while(!stack.isEmpty()) {
				TreeNode tempNode=stack.pop();
				System.out.printf("%d ",tempNode.val);
				if(!directionflag) {
					if(tempNode.left!=null) 
						tempStack.push(tempNode.left);
					if(tempNode.right!=null) 
						tempStack.push(tempNode.right);
				} else {
					if(tempNode.right!=null) 
						tempStack.push(tempNode.right);
					if(tempNode.left!=null) 
						tempStack.push(tempNode.left);
				}
			}
			// for changing direction
			directionflag=!directionflag; 
			stack=tempStack; 
		}
	}
	
	// prints in level order
	public void levelOrderTraversal() {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(this);
		while(!queue.isEmpty()) {
			TreeNode tempNode=queue.poll();
			System.out.printf("%d ",tempNode.val);
			if(tempNode.left!=null)
				queue.add(tempNode.left);
			if(tempNode.right!=null)
				queue.add(tempNode.right);
		}
	}
}
