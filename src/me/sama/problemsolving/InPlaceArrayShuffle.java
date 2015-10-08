package me.sama.problemsolving;

import java.util.Random;

/**
 * Created by ksama on 8/9/15.
 */
public class InPlaceArrayShuffle {
	public static void main(String[] args){
		int[] given = {1,2,3,4};
		for(int i=0;i<10;i++){
			given = inPlaceArrayShuffle(given);
			for(int j=0;j<given.length;j++){
				System.out.print(given[j]+",");
			}
			System.out.println();
			given = new int[]{1,2,3,4};
		}
	}
	private static int[] inPlaceArrayShuffle(int[] given){
		Random r = new Random();
		for(int i=given.length-1;i>0;i--){
			int index = r.nextInt(i+1);
			if(i == index)
				continue;
			given[i] = given[i]+given[index];
			given[index] = given[i]-given[index];
			given[i] = given[i]-given[index];
		}


		return given;
	}
}
