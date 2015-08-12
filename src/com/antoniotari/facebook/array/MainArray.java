package com.antoniotari.facebook.array;

public class MainArray {

	public static void main(String[] args) {
		int[] array={1,2,3,5,6,7,8,11,22,45,56,67};
		int val=higherSmaller(array,10);
		System.out.println(val);
		System.out.println(binarySearch(6,array));
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
	
    /**
     * Searches for the integer key in the sorted array a[].
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) {
            	hi = mid - 1;
            }
            else if (key > a[mid]) {
            	lo = mid + 1;
            }
            else 
            	return mid;
        }
        return -1;
    }
}
