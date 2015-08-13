package com.antoniotari.structures;

public class StructuresMain {

	public static void main(String... args){
		SinglyLinkedListNode<String> node1=new SinglyLinkedListNode<String>("1");
		SinglyLinkedListNode<String> node2=new SinglyLinkedListNode<String>("2");
		SinglyLinkedListNode<String> node3=new SinglyLinkedListNode<String>("3");
		SinglyLinkedListNode<String> node4=new SinglyLinkedListNode<String>("4");
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		printReverse(node1);
		
		for(String nodeData:node1){
		    System.out.println(nodeData);
		}
	}
	
	public static void printReverse(SinglyLinkedListNode<String> list) {
	    if (list==null) return;
	    if (list.iterator().hasNext()) {
	        printReverse(list.next);  
	    }
	    System.out.println(list.data);
	}
}


