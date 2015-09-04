package com.antoniotari.structures;

import java.util.Iterator;
import java.util.Stack;

public class SinglyLinkedListNode<T> implements Iterable<T>,Cloneable{
	public T data;
	public SinglyLinkedListNode<T> next;
	//public SinglyLinkedListNode<T> current;
		
	public SinglyLinkedListNode(T value){
		data=value;
		next=null;
	}
	
	@Override
	protected SinglyLinkedListNode<T> clone() throws CloneNotSupportedException{
		SinglyLinkedListNode<T> node = (SinglyLinkedListNode<T>) super.clone();
		node.data = data;
		node.next = next!=null?(SinglyLinkedListNode<T>) next.clone():null;
		return node;
	}
	
	@Override
	public Iterator<T> iterator() {
		/*return new Iterator<T>(){			
			@Override
			public boolean hasNext() {
				return current==null || current.next!=null;
			}

			@Override
			public T next() {
				if(current == null){
					current = SinglyLinkedListNode.this;
				} else {
					current=current.next;
				}
				return current.data;
			}
			
		};*/
		
		// this option is better because the cursor is initialized every time the iterarator is called
		return new ListIterator<T>(this);
	}
	
	private static class ListIterator<T> implements Iterator<T>{

		public SinglyLinkedListNode<T> cursor;

		public ListIterator(SinglyLinkedListNode<T> node) {
			cursor=node;
		}

		@Override
		public boolean hasNext() {
			return cursor!=null;
		}

		@Override
		public T next() {
			T data=cursor.data;
			cursor=cursor.next;
			return data;
		}
		
	}
}
