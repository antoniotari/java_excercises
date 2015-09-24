package com.antoniotari.excercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Chess knight on phone pad
 * 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *   0
 *
 * Given a knight starts at position 1
 * And given an input of number of moves
 * How many different paths can the knight take?
 *
 *
 * Examples:
 *
 * input 0 -> output 1
 *  Possible paths:
 *   1
 *
 * input 1 -> output 2
 *  Possible paths:
 *   1 -> 6
 *   1 -> 8
 *
 * input 2 -> output 5
 *  Possible paths:
 *   1 -> 6 -> 1
 *   1 -> 6 -> 7
 *   1 -> 6 -> 0
 *   1 -> 8 -> 1
 *   1 -> 8 -> 3
 *
 */

public class ChessQuestionMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totMoves = in.nextInt();
		in.close();

		int moveCounter=0;
		int paths=0;
		int count=findPaths(totMoves,1,/*done,*/moveCounter,paths);
		System.out.println(count);

		/*int count=0;
		for(int i=0;i<=9;i++){
			if(done.get(i))count++;
		}*/
	}

	public static int findPaths(final int numberOfMoves,int startingPoint,int moveCounter,int paths){
		
		if(moveCounter++<numberOfMoves){
			for(int i:getMoves(startingPoint)){	
				paths=((moveCounter==numberOfMoves?1:0)+findPaths(numberOfMoves,i/*,done*/,moveCounter,paths));
			}
		}
		return paths;
	}

	public static int[] getMoves(int position){
		switch(position){
		case 0:
			return new int[] {4, 6};
		case 1:
			return new int[] {6, 8};
		case 2:
			return new int[] {7, 9};
		case 3:
			return new int[] {4, 8};
		case 4:
			return new int[] {3, 9, 0};
		case 6:
			return new int[] {1, 7, 0};
		case 7:
			return new int[] {2, 6};
		case 8:
			return new int[] {1, 3};
		case 9:
			return new int[] {2, 4};
		}
		return null;
	}

}
