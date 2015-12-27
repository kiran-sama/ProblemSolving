package me.sama.problemsolving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinimumSubstringFinder {
  public static void main(String args[]) {
    String s = "cankdbghsaggsbcjhkhkcanb";
    String t = "abc";
    HashSet<Character> set = new HashSet<Character>();
    HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
    PriorityQueue<Integer> indexQueue = new PriorityQueue<Integer>();
    for (int i = 0; i < t.length(); i++) {
      char temp = t.charAt(i);
      set.add(temp);
      targetMap.put(temp, 0);
    }

    int start = 0;
    int end = 0;
    char next;
    boolean firstIteration = true;
    for (int j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      if (firstIteration) {
        if (set.contains(c)) {
          set.remove(c);
          indexQueue.add(j);
          targetMap.put(c, j);
        }
        if (set.isEmpty()) {
          start = indexQueue.poll();
          end = j;
        }
      } else {
        if (targetMap.containsKey(c)) {
          indexQueue.add(j);
          targetMap.put(c, j);
        }

      }
    }
  }

  private static char nextChar(HashMap<Character, Integer> targetMap, PriorityQueue<Integer> indexQueue){
   return 'd';
  }
}
