package com.antoniotari.facebook.strings;

public class StringsMain {

	public static void main(String[] args) {
		String checkS="itopinonavevanonipoti";
		System.out.println("palindrome "+isPalindrome(checkS));
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
	
}
