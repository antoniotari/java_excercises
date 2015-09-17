package com.antoniotari.excercises.strings;

import java.util.ArrayList;

import com.antoniotari.excercises.L;

public class StringsMain {

	public static void main(String[] args) {
		String checkS="itopinonavevanonipoti";
		System.out.println("palindrome "+isPalindrome(checkS));
		String str="antonio8tari8will8make8it12345656565656565656565ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		L.log(String.valueOf(reverseWordsOrder(str.toCharArray())));
	}

	/**
	 * check if a string is palindrome
	 */
	static boolean isPalindrome(String s) {
		  for (int i=0;i<(s.length() / 2) + 1;++i) {
		     if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
		         return false;
		     }
		  }
		  return true;
		}
	
	/**
	 * complexity O(n^2/2)
	 * @param chars
	 * @return
	 */
	static char[] reverseWordsOrder(char[] chars){
		char[] result=new char[chars.length];
		for(int i=0;i<result.length;i++){
			result[i]='_';
		}
		int count=0;
		int lastI=chars.length-1;
		for(int i=0;i<chars.length;i++){
			char c = chars[i];
			if(!Character.toString(c).equals(" ")){
				//move left one position
				for(int j=chars.length-i;j<=lastI;j++){
					if(j>0){
						result[j-1]=result[j];
					}
					count++;
				}
				result[lastI]=c;
				//L.log(String.valueOf(result));
			} else {
				result[chars.length-i-1]=' ';
				lastI=chars.length-i-2;
				count++;
			}
		}
		int letn=chars.length/2;
		L.log(chars.length*chars.length);
		L.log(count,chars.length);
		return result;
	}
	
	public static String longestCommonSubsequence(String a, String b){
	    int aLen = a.length();
	    int bLen = b.length();
	    if(aLen == 0 || bLen == 0){
	        return "";
	    }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
	        return longestCommonSubsequence(a.substring(0,aLen-1),b.substring(0,bLen-1)) + a.charAt(aLen-1);
	    }else{
	        String x = longestCommonSubsequence(a, b.substring(0,bLen-1));
	        String y = longestCommonSubsequence(a.substring(0,aLen-1), b);
	        return (x.length() > y.length()) ? x : y;
	    }
	}
}
