package me.sama.problemsolving;

/**
 * Created by ksama on 8/4/15.
 */
public class MergeSort {
	private static void sort(int[] unsorted){
	}

	private static void subroutine(int[] unsorted, int start, int end){
		if(start == end){
			return;
		}
		int mid = (start+end)/2;
		subroutine(unsorted,start,mid);
		subroutine(unsorted,mid+1,end);
		merge(unsorted, start,mid,mid+1,end);
	}

	private static void merge(int[] unsorted,int start1,int end1,int start2,int end2){

	}
}
