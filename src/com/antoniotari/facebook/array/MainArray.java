package com.antoniotari.facebook.array;

public class MainArray {

	public static void main(String[] args) {
		int[] array={1,2,3,5,6,7,8,11,22,45,56,67};
		int[] array1={1,2,8,10,21,32};
		int val=higherSmaller(array,10);
		System.out.println(val);
		System.out.println(array[higherSmallerBinarySearch(10,array)]);
		System.out.println(binarySearch(45,array));
		
		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
	}
	
	//given a target and a sorted array, find the highest value smaller than the target
	/**
	 * @return null if nothing is found
	 */
	public static Integer higherSmaller(final int[] array,final int target){
		Integer current=null;
		int i=0;
		while(array[i]<target){
			current = array[i];
			i++;
		}
		return current;
	}
	
    public static int higherSmallerBinarySearch(int key, int[] array) {
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
    public static int binarySearch(int key, int[] array) {
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
}
