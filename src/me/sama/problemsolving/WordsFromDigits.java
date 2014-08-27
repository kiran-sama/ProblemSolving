package me.sama.problemsolving;

import java.util.HashMap;
import java.util.Map;
/*
When there are dynamic no of for loops required to solve the problem.
Check Recursion if you can break that into sub problems
 */
public class WordsFromDigits {
  static char[] stringCombination = null;
  static void printWords(int[] digits, Map<Integer,char[]> map) {
    if(map == null)
      throw new IllegalArgumentException();
    stringCombination = new char[digits.length];
    /*
    This problem is a exponential problem. So doing it in for loops is not possible.
    Breaking up this into subproblems where you take position by position.Add for loop for iteration at current digit
    then recursively go down.
     */
    printWordsSubMethod(digits,0,map);
  }

  static void printWordsSubMethod(int[] digits,int currentDigit,Map<Integer,char[]> map){
    /*
    BaseCase:
    When you add all characters into the array print the string
     */
    if(currentDigit == digits.length){
      System.out.println(stringCombination);
      return;
    }
    char[] uniqueChars = map.get(digits[currentDigit]);
    if(uniqueChars != null) {
    for(char oneUniqueChar:uniqueChars){
      stringCombination[currentDigit] = oneUniqueChar;
      printWordsSubMethod(digits,currentDigit+1,map);
    }
    } else {
      printWordsSubMethod(digits,currentDigit+1,map);
    }



  }

    /*
    Tetsing the code
     */
    public static void main(String[] args) {
     int[] digits = {1,2,3};
     Map<Integer, char[]> map = new HashMap<Integer, char[]>();
      map.put(1,new char[]{'a','b','c'});
      map.put(2,new char[]{'d','e','f'});
      map.put(3,new char[]{'g','h','i'});
      map.put(4,new char[]{'j','k','l'});
      map.put(5,new char[]{'m','n','o'});
      map.put(6,new char[]{'p','q','r'});

      printWords(digits, map);
      digits = new int[]{1,7,3};
      printWords(digits, map);
    }
}
