package me.sama.problemsolving;

/**
 * Created by ksama on 11/4/15.
 */
public class ContinuousSum {
  public static void main(String args[]){
    int[] input = {100,1,2,3,4,5,6,7,8,9,10,11,12,13};
    int sum = 27;
    System.out.println(isSumExists(input, sum));

  }

  protected  static boolean isSumExists(int[] input, int sumGiven){
    int start =0;
    int sum = 0;
     for(int i=0;i<input.length;i++){
        sum = sum+input[i];
       if(sum == sumGiven)
         return true;
       else if(sum < sumGiven)
         continue;
       else{
         while(sum>sumGiven){
           sum = sum - input[start++];
         }
         if(sum == sumGiven)
           return true;
         else
           continue;
       }


     }
    return false;
  }
}
