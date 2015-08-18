package com.antoniotari.structures;

public class PriorityObject implements Comparable<PriorityObject>{

	public String name;
	private int priority;
	
	public PriorityObject(int priority){
		this.priority=priority;
	}

	@Override
	public int compareTo(PriorityObject o) {
		return priority-o.priority;
	}
	
	@Override
	public String toString(){
		return String.valueOf(priority);
	}
}
