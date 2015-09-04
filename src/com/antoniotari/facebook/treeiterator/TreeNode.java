package com.antoniotari.facebook.treeiterator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode implements Iterable<TreeNode>,Serializable{
	static final long serialVersionUID = 35464376234L;
	public int val; 
	transient public TreeNode left; 
	transient public TreeNode right;

	public TreeNode(int val){
		this.val=val;
	}


	@Override
	public Iterator<TreeNode> iterator() {
		return new TreeIterator(this);
	} 

	/**
	 * check if an element is present in the tree
	 * @param target
	 * @return
	 */
	public boolean isPresent(int target){
		return isPresent(this,target);
	}

	private boolean isPresent(TreeNode node,int target){
		// 1. Base case == empty tree 
		// in that case, the target is not found so return false 
		if (node == null) { 
			return false; 
		} 
		else { 
			// 2. see if found here 
			if (target == node.val) return true; 
			else { 
				// 3. otherwise recur down the correct subtree 
				if (target < node.val) {
					return(isPresent(node.left, target)); 
				}
				else {
					return(isPresent(node.right, target)); 
				}
			} 
		} 
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

	/**
	 * serialize the tree and write to file
	 * @param filename
	 * @return
	 */
	public List<TreeNode> serialize(String filename) {
		List<TreeNode> list=new ArrayList<TreeNode>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(this);
		while(!queue.isEmpty()) {
			TreeNode tempNode=queue.poll();
			list.add(tempNode);
			if(tempNode!=null){
				queue.add(tempNode.left);
				queue.add(tempNode.right);
			}
		}

		try (
				OutputStream file = new FileOutputStream(filename);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
			output.writeObject(list);
		}  
		catch(IOException ex){
		}

		return list;
	}

	public static TreeNode deserialize(/*final List<TreeNode> list, */String filename){
		List<TreeNode> list=null;
		try(
				InputStream file = new FileInputStream(filename);
				InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream (buffer);
				){
			list = (List<TreeNode>)input.readObject();
		} catch(ClassCastException|ClassNotFoundException|IOException ex){
			return null;
		}

		for(int i=0;i<list.size();i++){
			int level = (int)(Math.sqrt(i+i));
			TreeNode node = list.get(i);
			if(node!=null){
				int posL= (int) (i + Math.pow(2, level) + ((i+1)-Math.pow(2, level)));
				if(posL<list.size())
					node.left=list.get(posL);
				if(posL+1<list.size())
					node.right=list.get(posL+1);
			}
		}
		return list.get(0);
	}
}
