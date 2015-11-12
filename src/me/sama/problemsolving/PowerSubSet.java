package me.sama.problemsolving;

import java.util.ArrayList;

/**
 * Created by ksama on 10/8/15.
 */
public class PowerSubSet {
  public static void main(String args[]){
    printSubsets(new int[]{1, 2,3,4});
  }

  public static void printSubsets(int[] set){
    printSubsetsHelper(set,0,new ArrayList<Integer>());
  }

  public static void printSubsetsHelper(int[] set, int index,ArrayList<Integer> list){
     if(index == set.length) {
       printList(list);
     }
    else{
       printSubsetsHelper(set, index + 1, (ArrayList<Integer>) list.clone());
       list.add(set[index]);
       printSubsetsHelper(set, index + 1, list);
     }
  }

  private static void printList(ArrayList<Integer> list){
    System.out.print("{ ");
    for(int i:list){
      System.out.print(i+" ");
    }
    System.out.println("}");
  }
}
