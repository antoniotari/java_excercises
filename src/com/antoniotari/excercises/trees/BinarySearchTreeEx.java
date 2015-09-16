package com.antoniotari.excercises.trees;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import com.antoniotari.excercises.L;

public class BinarySearchTreeEx{
	
	public static class Node<K extends Comparable<K>,V> implements Iterable<Node<K,V>>,Cloneable{
		
		V value;
		K key;
		int totNodes;
		Node<K,V> left;
		Node<K,V> right;
		
		public Node(K key,V value){
			this.value=value;
			this.key=key;
			totNodes=1;
		}
		
		public int size(){
			return size(this);
		}
		
		public int size(Node<K,V> node){
			if(node==null)return 0;
			return node.totNodes;
		}
		
		public V get(K key){
			return get(key,this);
		}
		
		public V get(K key,Node<K,V> node){
			if(node==null)return null;
			int cmp = key.compareTo(node.key);
			if(cmp<0){
				return get(key,node.left);
			} else if(cmp>0){
				return get(key,node.right);
			} else {
				return node.value;
			} 
		}
		
		public void put(K newKey,V newValue){
			put(this,newKey,newValue);
		}
		
		public Node<K,V> put(Node<K,V> node,K newKey,V newValue){
			if(node==null){
				return new Node<K,V>(newKey,newValue);
			}
			
			int cmp = newKey.compareTo(node.key);
			if(cmp<0){
				node.left = put(node.left,newKey,newValue);
			} else if(cmp>0){
				node.right = put(node.right,newKey,newValue);
			} else {
				node.value=newValue;
			} 
			
			node.totNodes = 1+size(node.left)+size(node.right);
			return node;
		}
		
		@Override
		public Object clone() throws CloneNotSupportedException{
			Node<K,V> node =(Node<K,V>) super.clone();
			node.key=key;
			node.value=value;
			if(node.left!=null)
				node.left=(Node<K,V>)node.left.clone();
			if(node.right!=null)
				node.right=(Node<K,V>)node.right.clone();
			
			return node;
		}
		
		@Override
		public Iterator<Node<K,V>> iterator() {
			return new TreeIterator(Node.this);
		}
		
		class TreeIterator implements Iterator<Node<K,V>>{
			Stack<Node<K,V>> nodeStack;
			Node<K,V> mCurrentNode;
			
			public TreeIterator(Node<K,V> root){
				nodeStack= new Stack<Node<K,V>>();
				//nodeStack.push(root);
				mCurrentNode=root;
			}
			
			@Override
			public boolean hasNext() {
				return !nodeStack.isEmpty() || mCurrentNode!=null;
			}

			@Override
			public Node<K,V> next() {
				if(mCurrentNode!=null){  
					nodeStack.push(mCurrentNode);  
					mCurrentNode=mCurrentNode.left;  
					return next();
				} else {  
					Node<K,V> n=nodeStack.pop();  
					//System.out.printf("%d ",n.data);  
					mCurrentNode=n.right;  
					return n;
				}  

				/*
				Node<K,V> currentNode=nodeStack.pop();

				if(currentNode.right!=null){
					nodeStack.push(currentNode.right);
				}
				if(currentNode.left!=null){
					nodeStack.push(currentNode.left);
				} 
				return currentNode;		
				 */	
			}

		}
	}
	
	
		
	public static void main(String[] ards){
		Node<Integer,String> root=new Node<Integer,String>(5,"r");
		root.put(77,"s");
		root.put(3,"rf");
		root.put(98,"rg");
		root.put(11,"hr");
		root.put(62,"yr");
		root.put(12,"ur");
		root.put(15,"ir");
		root.put(101,"nr");
		root.put(150,"nr");
		root.put(310,"nr");
		root.put(109,"nr");
		
		for(Node<Integer,String> node:root){
			L.log(node.key);
		}
		
		try {
			Node<Integer,String> root2=(Node<Integer,String>)root.clone();
			for(Node<Integer,String> node:root2){
				L.log(node.key);
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
