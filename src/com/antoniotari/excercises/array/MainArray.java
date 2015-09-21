package com.antoniotari.excercises.array;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.antoniotari.excercises.L;

public class MainArray {

	public static void main(String[] args) {
		Integer[] array={1,2,3,5,6,7,8,11,22,45,56,67};
		Integer[] array1={1,2,8,10,21,32};
		int val=higherSmaller(array,10);
		System.out.println(val);
		System.out.println(array[higherSmallerBinarySearch(10,array)]);
		System.out.println(binarySearch(45,array));
		L.log("has duplicates?",hasDuplicates(array));
		
		Integer[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        
		L.log(findConsecutiveThatSumsToTarget(inputArr,292));
		L.log(isNumbersThatSumToX(inputArr,0,58));

        MergeSort<Integer> mms = new MergeSort<Integer>();
        mms.sort(inputArr);
        L.log(inputArr);
        L.nl();
	}
	
	//given a target and a sorted array, find the highest value smaller than the target
	/**
	 * @return null if nothing is found
	 */
	public static Integer higherSmaller(final Integer[] array,final int target){
		Integer current=null;
		int i=0;
		while(array[i]<target){
			current = array[i];
			i++;
		}
		return current;
	}
	
    public static int higherSmallerBinarySearch(int key, Integer[] array) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if(key < array[mid]) {
            	hi = mid - 1;
            }else if(key > array[mid]) {
            	if( Math.abs(hi-lo)<=1 && (hi== mid || lo==mid)){
            		return mid;
            	}
            	lo = mid + 1;
            } else {
            	hi = mid - 1;
            }
        }
        return -1;
    }
	
    /**
     * Searches for the integer key in the sorted array a[].
     * STEPS
     * - start with lo and hi set to 0 and the last element (length-1)
     * - calculate mid each iteration mid = lo + (hi-lo)/2
     * - if the target is bigger than the position it means we have to look in the second part of the array so lo=mid+1
     *   if the target is smaller than the position it means we have to look in the first part of the array so hi=mid-1
     *   if equal we found the position
     * @param key the search key
     * @param array the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int binarySearch(int key, Integer[] array) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            // Key is in array[lo..hi] or not present.
            int mid = lo+(hi-lo)/2;
            if(key < array[mid]) {
            	hi = mid - 1;
            }else if(key > array[mid]) {
            	lo = mid + 1;
            }else {
            	return mid;
            }
        }
        return -1;
    }
    
    /**
     * this binary search will work on a rotated sorted array too
     * @param array
     * @param key
     * @return
     */
    public static int rotatedBinarySearch(int[] array, int key) {
    	int left = 0;
    	int right = array.length - 1;

    	while (left <= right) {
    		// Avoid overflow, same as M=(L+R)/2
    		int mid = left + ((right - left) / 2);
    		if (array[mid] == key) return mid;

    		// the bottom half is sorted
    		if (array[left] <= array[mid]) {
    			if (array[left] <= key && key < array[mid]){
    				right = mid - 1;
    			} else {
    				left = mid + 1;
    			}
    		}
    		// the upper half is sorted
    		else {
    			if (array[mid] < key && key <= array[right]){
    				left = mid + 1;
    			} else { 
    				right = mid - 1;
    			}
    		}
    	}
    	return -1;
    }
    
    /**
     * GIVEN:
     * 		-array of consecutive integers
     * 		-target integer
     * FIND:
     * 		if there's a consecutive sub-array that sums to target
     */
    public static boolean findConsecutiveThatSumsToTarget(Integer[] array,int target){
    	int j=0;
    	int sum=0;
    	for(int i=0;i<array.length;i++){
    		while(sum>target && j<i-1){
    			sum-=array[j++];
    		}
    		if(sum==target)return true;
    		sum+=array[i];
    	}
    	return false;
    }
    
    /**
     * in a list of integers find if there are n numbers that sum to x
     * this is O(n2) since we execute the outer loop O(n) times and we execute the inner loop O(n) times
     */
    public static boolean isNumbersThatSumToX(Integer[] array,int n,int x){
    	//sort the array
    	new MergeSort<Integer>().sort(array);
    	
    	for(int i=0;i<array.length;i++){
    		int j=i+1;
    		int k=array.length-1;
    		while(k>=j){
    			int sum = array[i]+array[k]+array[j];
    			if(sum==x)return true;
    			//if sum is too big decrement k else increment j
    			if(sum>0) --k; else ++j;
    		}
    	}
    	return false;
    }
    
    public static boolean hasDuplicates(Integer[] array){
    	new MergeSort<Integer>().sort(array);
    	
    	for(int i=0;i<array.length-1;i++){
    		if(array[i]+array[i+1]==array[i]*2){
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean hasDuplicates2(Integer[] array){
    	Set<Integer> integerSet=new LinkedHashSet<Integer>();
    	for(Integer inte:array){
    		if(!integerSet.add(inte))return true;
    	}
    	return false;
    }
    
}
