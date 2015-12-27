package me.sama.problemsolving;

import java.util.*;

public class Solution {
  public int[] nthSuperUglyNumber(int n, int[] primes) {
    int[] uglyNumbers = new int[n];
    uglyNumbers[0] = 1;
    int[] factorsPrimeWise = new int[primes.length];
    int[] uglyNumbersPrimeWise = new int[primes.length];
    for(int i=0;i<primes.length;i++){
      uglyNumbersPrimeWise[i] = primes[i];
    }
    for(int i=1;i<n;i++){
      int min =Integer.MAX_VALUE;;
      int index = -1;
      for(int j=0;j<primes.length;j++){
        if(uglyNumbersPrimeWise[j]<min){
          min = uglyNumbersPrimeWise[j];
          index = j;
        }
      }
      uglyNumbers[i] = min;
      factorsPrimeWise[index]++;
      uglyNumbersPrimeWise[index] = uglyNumbers[factorsPrimeWise[index]]*primes[index];
      boolean check =  false;
      for(int j=0;j<primes.length;j++){
        if(uglyNumbersPrimeWise[index]==uglyNumbersPrimeWise[j] && j!=index){
          check = true;
          break;
        }
      }
      while(check){
        factorsPrimeWise[index]++;
        uglyNumbersPrimeWise[index] = uglyNumbers[factorsPrimeWise[index]]*primes[index];
        for(int j=0;j<primes.length;j++){
          if(uglyNumbersPrimeWise[index]==uglyNumbersPrimeWise[j] && j!=index){
            check = true;
            break;
          }
        }
      }

    }
    return uglyNumbers;

  }

  public static void main(String[] args){
       int[] result = new Solution().nthSuperUglyNumber(12,new int[]{2,7,13,19});
       for(int i=0;i<result.length;i++){
         System.out.println(result[i]);
       }
  }

}