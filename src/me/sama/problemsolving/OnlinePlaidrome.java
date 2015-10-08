package me.sama.problemsolving;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * bcacacb
 * Created by ksama on 10/4/15.
 */
public class OnlinePlaidrome {
  static ArrayList<Character> word = new ArrayList<Character>();
  static int nextMatchPosition = 0;
  static boolean dontcheck = true;
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    while(true) {
      isPalindrome(scanner.next().charAt(0));
    }
  }

  private static void isPalindrome(char ch){
    if(word.size()==0) {
      System.out.println(true);
      word.add(ch);
      nextMatchPosition = 0;
      return;
    }
    if(dontcheck){
      word.add(ch);
      System.out.println(false);
    }
    if(word.get(nextMatchPosition) == ch){
      if(nextMatchPosition == 0) {
        System.out.println(true);
        dontcheck = true;
      }
      else{
        System.out.println();
      }
    }

  }
}
