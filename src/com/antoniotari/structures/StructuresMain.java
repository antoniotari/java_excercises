package com.antoniotari.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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
		
		testPriorityQueue();
	}
	
	public static void printReverse(SinglyLinkedListNode<String> list) {
	    if (list==null) return;
	    if (list.iterator().hasNext()) {
	        printReverse(list.next);  
	    }
	    System.out.println(list.data);
	}
	
	/**
	 * - Unconditionnally insert into the queue the n first elements
	 * - For each remaining element x, insert x if it is greater than the least element of 
	 *   the queue (O(log n) operation), and remove the least element (O(log n)).
	 * - When done, the priority queue contains n elements, which are the n largest 
	 *   elements of the original array.
	 * 
	 * Total complexity: O(N log n) where N is the total number of elements in the array.
	 * 
	 */
	public static void testPriorityQueue(){
		//System.out.println("\n");
		//System.out.println("\n");
		int queueSize=4;

		PriorityObject[] array=new PriorityObject[10];
		//create random array
		for(int i=0;i<array.length;i++){
			Random rand = new Random();
			array[i]= new PriorityObject(rand.nextInt((111111111 - 2) + 1) + 2);
			//System.out.println(array[i]);
		}			
		//System.out.println("\n");

		
		PriorityQueue<PriorityObject> queue = new PriorityQueue<PriorityObject>(queueSize);
		//add the first queueSize elements to the queue
		for(int i=0;i<queueSize;i++){
			queue.add(array[i]);
		}
		
		//iterate the array and replace the lowest if a larger element found
		for(int i=queueSize;i<array.length;i++){
			//System.out.println(queue.peek().toString()+" "+array[i].toString());
			if(queue.peek().compareTo(array[i])<0){
				//System.out.println("replacing");
				queue.poll();
				queue.add(array[i]);
			}
		}
		//System.out.println("\n");

		PriorityObject po=queue.poll();
		while(po!=null){
			System.out.println(po.toString());
			po=queue.poll();
		}
	}
	
	/**
	 * merge k ordered lists
	 * Time: log(k) * n.
	 * k is number of list and n is number of total elements.
	 */
	public SinglyLinkedListNode<Integer> mergeKLists(ArrayList<SinglyLinkedListNode<Integer>> lists) {
		if (lists.size() == 0) return null;
 
		//PriorityQueue is a sorted queue
		PriorityQueue<SinglyLinkedListNode<Integer>> q = new PriorityQueue<SinglyLinkedListNode<Integer>>(lists.size(),
				new Comparator<SinglyLinkedListNode<Integer>>() {
					public int compare(SinglyLinkedListNode<Integer> a, SinglyLinkedListNode<Integer> b) {
						if ((a.data) > (b.data))
							return 1;
						else if(a.data == b.data)
							return 0;
						else 
							return -1;
					}
				});
 
		//add first node of each list to the queue
		for (SinglyLinkedListNode<Integer> list : lists) {
			if (list != null)
				q.add(list);
		}
 
		SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<Integer>(0);
		SinglyLinkedListNode<Integer> p = head; // serve as a pointer/cursor
 
		while (q.size() > 0) {
			SinglyLinkedListNode<Integer> temp = q.poll();
			//poll() retrieves and removes the head of the queue - q. 
			p.next = temp;
 
			//keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);
 
			p = p.next;
		}
 
		return head.next;
	}
	
	/**
	 * delete duplicates from list
	 * @param head
	 * @return
	 */
	public SinglyLinkedListNode<Integer> deleteDuplicates(SinglyLinkedListNode<Integer> head) {
        if(head == null || head.next == null)return head;

        SinglyLinkedListNode<Integer> p = head;
        while( p!= null && p.next != null){
            if(p.data == p.next.data){
                p.next = p.next.next;
            }else{
                p = p.next; 
            }
        }
        return head;
    }
}


