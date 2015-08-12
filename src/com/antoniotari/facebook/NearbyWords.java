package com.antoniotari.facebook;

import java.util.HashSet;
import java.util.Set;


/**
 * The complexity of that algorithm is O(n^m), where:
 *  n - the length of a string.
 *  m - number of permutations.
 */
public class NearbyWords {

	public static void main(String[] args) {
		System.out.println(nearbyWords("gi"));
		
		double num=2.0d;//444444434535.54345435343d;
		System.out.println(Math.sqrt(num));
		System.out.println(invSqrt(num));
		System.out.println(square(num,2));
	}

	public static double invSqrt(double x) {
	    double xhalf = 0.5d*x;
	    long i = Double.doubleToLongBits(x);
	    i = 0x5fe6ec85e7de30daL - (i>>1);
	    x = Double.longBitsToDouble(i);
	    x = x*(1.5d - xhalf*x*x);
	    x = x*(1.5d - xhalf*x*x);
	    return 1/x;
	}
	
	public static double square(final double s,final int root){
		double guess = s;
		double previous=-1;
		int i=0;
		while(Math.abs(previous-guess)>0.0000000001){
			previous=guess;
			++i;
			double top=guess;
			for(int it=1;it<root;it++){
				top*=guess;
			}
			double bot=(top/guess)*root;
			//System.out.println(guess+" "+top+" "+bot);
			guess = guess - ((top - s)/bot);
		}
		System.out.println("iterations: "+i);

		return guess;
	}
	
	static Set<String> nearbyWords(String input) {
		char[] letters = input.toCharArray();
		Set<String> nearbyPermutations = nearbyPermutations(letters, 0);
		Set<String> words = new HashSet<>();
		for (String pw : nearbyPermutations) {
			if (isword(pw)) {
				words.add(pw);
			}
		}
		return words;
	}

	private static Set<String> nearbyPermutations(char[] letters, int index) {
		if (index >= letters.length) {
			HashSet<String> strings = new HashSet<>();
			strings.add("");
			return strings;
		}

		Set<String> subWords = nearbyPermutations(letters, index + 1);
		Set<Character> nearbyLetters = getNearbyChars(letters[index]);

		return permutations(subWords, nearbyLetters);
	}

	private static Set permutations(Set<String> subWords, Set<Character> nearbyLetters) {
		Set permutations = new HashSet<>();

		for (String subWord : subWords) {
			for (Character letter : nearbyLetters) {
				permutations.add(letter + subWord);
			}
		}
		return permutations;
	}


	//Lame implementation of helpers.
	private static Set<Character> getNearbyChars(Character character) {
		HashSet<Character> characters = new HashSet<>();
		if (character == 'g') {
			characters.add('g');
			characters.add('h');
			characters.add('f');
		} else {
			characters.add('i');
			characters.add('o');
			characters.add('k');
		}
		return characters;
	}

	static boolean isword(String word) {
		return word.equals("go") || word.equals("hi");
	}
}