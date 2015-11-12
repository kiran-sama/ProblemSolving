package me.sama.problemsolving;

/**
 * Created by ksama on 10/14/15.
 */
public class IndexValueSearch {
  public static void main(String[] args){
    int[] sorted = {-2,0,5,5,5,6, 8,10};
    System.out.println(search(sorted,0,sorted.length-1));
  }

  public static boolean  search(int[] sorted, int start, int end){
    if(start == end){
      return start == sorted[start];
    } else if(start > end){
      return false;
    }
    else{
      int mid = (start+end)/2;
      if(sorted[mid] == mid)
        return true;
      else if(sorted[mid] > mid)
        return search(sorted,sorted[mid],end) || search(sorted,start,mid-1);
      else
        return search(sorted,mid+1,end) || search(sorted,start,sorted[mid]);
    }
  }
}
