package com.antoniotari.structures;

import java.util.Iterator;
import java.util.Stack;

public class SinglyLinkedListNode<T> implements Iterable<T>{
	public T data;
	public SinglyLinkedListNode<T> next;
	public SinglyLinkedListNode<T> current;
		
	public SinglyLinkedListNode(T value){
		data=value;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){

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
			
		};
		//return new ListIterator<T>(this);
	}
	
	/*private static class ListIterator<T> implements Iterator<T>{

		public SinglyLinkedListNode<T> mNode;

		public ListIterator(SinglyLinkedListNode<T> node) {
			mNode=node;
		}

		@Override
		public boolean hasNext() {
			return mNode.next!=null;
		}

		@Override
		public T next() {
			return mNode.next.data;
		}
		
	}*/


}
