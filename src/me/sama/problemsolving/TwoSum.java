package me.sama.problemsolving;

import java.util.HashMap;

/**
 * Created by ksama on 10/6/15.
 */
public class TwoSum {


  static int palindrome(String str) {
    HashMap<String,Integer> panidromeMap = new HashMap<String,Integer>();
    for(int i=0;i<str.length();i++){
      for(int j=1;j<=str.length()-i;j++){
        String subString = str.substring(i,i+j);
        if(panidromeMap.containsKey(subString))
          continue;
        else{
          if(isPalindrome(subString)){
            panidromeMap.put(subString,1);
          }else{
            panidromeMap.put(subString,0);
          }
        }
      }

    }
    int count =0;
    for(Integer value:panidromeMap.values()){
      count=count+value;
    }
    return count;

  }

  static boolean isPalindrome(String str){
    if (str.length() < 2) return true;
    if (str.charAt(0) == str.charAt(str.length() - 1)) {
      return isPalindrome(str.substring(1, str.length() - 1));
    }
    else {
      return false;
    }
  }


  public static void main(String[] args) {
    System.out.println(palindrome("aabaa"));
  }
}
