package com.antoniotari.excercises.trees;
import java.util.List;

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
		
		System.out.println("is present? "+root.isPresent(3));
		
		TreeNode zigZag=createBinaryTree();
		zigZag.spiralOrZigzagLevelOrder();
		System.out.println("\n");
		zigZag.levelOrderTraversal();
		System.out.println("\n");
		System.out.println("serialized list");
		List<TreeNode> seri=zigZag.serialize("quarks.ser");
		for (TreeNode node:seri){
			if(node!=null)
				System.out.printf("%d ",node.val);
			else
				System.out.print("N ");
		}
		TreeNode root2 = TreeNode.deserialize("quarks.ser");
		System.out.println("\n");
		root2.levelOrderTraversal();
		/*for (Iterator<TreeNode> iter = root.iterator(); iter.hasNext(); ) {
			System.out.println(iter.next().val);
		}*/
	}
	
	 public static TreeNode createBinaryTree() {
	  
	  TreeNode rootNode =new TreeNode(40);
	  TreeNode node20=new TreeNode(20);
	  TreeNode node10=new TreeNode(10);
	  TreeNode node30=new TreeNode(30);
	  TreeNode node60=new TreeNode(60);
	  TreeNode node50=new TreeNode(50);
	  TreeNode node70=new TreeNode(70);
	  TreeNode node5=new TreeNode(5);
	  TreeNode node55=new TreeNode(55);
	  
	  rootNode.left=node20;
	  rootNode.right=node60;
	  
	  node20.left=node10;
	  node20.right=node30;
	  
	  node60.left=node50;
	  node60.right=node70;
	  node10.left=node5;
	  node50.right=node55;
	  
	  return rootNode;
	 }
}
