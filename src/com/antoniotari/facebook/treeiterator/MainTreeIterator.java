package com.antoniotari.facebook.treeiterator;

import java.util.Iterator;

public class MainTreeIterator {
	public static void main(String[] args) {
		//tree iterator
		TreeNode root=new TreeNode(36);
		TreeNode node1=new TreeNode(32);
		TreeNode node2=new TreeNode(23);
		TreeNode node3=new TreeNode(34);
		TreeNode node4=new TreeNode(230);
		TreeNode node5=new TreeNode(243);
		TreeNode node6=new TreeNode(723);

		root.left=node1;
		root.right=node2;
		node1.right=node3;
		node1.left=node4;
		node2.right=node5;
		node2.left=node6;

		
		for(TreeNode node:root){
			System.out.println(node.val);

		}
		
		/*for (Iterator<TreeNode> iter = root.iterator(); iter.hasNext(); ) {
			System.out.println(iter.next().val);
		}*/
	}
}
