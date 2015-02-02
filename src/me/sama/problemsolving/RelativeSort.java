package me.sama.problemsolving;

import java.util.HashMap;

/**
 * User: samanitw
 * Date: 8/26/14
 * Example: Unsorted={4,2,3,6,19,29,1,3,4,7} otherArray={4,2,7}
 * We need to sort elements in unsorted array based on the ordering of other array.
 * If there are some numbers missing in otherarray we should move them to the end and sort them based on natural order
 * output= {4,4,2,7,1,3,3,6,19,29}
 */
public class RelativeSort {

  static int[] relativeSort(int[] unsortedNumbers, int[] referenceOrderItems) {
    HashMap<Integer,Integer> referenceMap = new HashMap<Integer, Integer>();
    for(int referenceOrderItem:referenceOrderItems){
      referenceMap.put(referenceOrderItem,0);
    }
    for(int i=0,j=unsortedNumbers.length-1; i<unsortedNumbers.length; i++){
      Integer lookup = referenceMap.get(unsortedNumbers[i]);
      if(lookup != null){
        referenceMap.put(unsortedNumbers[i],lookup.intValue()+1);
      } else{
        while(referenceMap.get(unsortedNumbers[j]) == null || i<j){
          j--;
        }
        if(i==j)
          break;
        lookup = referenceMap.get(unsortedNumbers[j]);
        referenceMap.put(unsortedNumbers[j], lookup.intValue()+1);
        unsortedNumbers[j] = unsortedNumbers[i];

      }
    }
    return unsortedNumbers;
  }

  public static void main(String args[]){
    System.out.println(System.currentTimeMillis());
    System.out.println(System.nanoTime());
    /*int[] unsorted = {2,4};
    int[] referenceOrder = {4};
    unsorted = relativeSort(unsorted, referenceOrder);
    for(int value:unsorted){
      System.out.print(value);
    }*/

  }
}
