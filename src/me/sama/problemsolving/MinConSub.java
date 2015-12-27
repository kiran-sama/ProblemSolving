package me.sama.problemsolving;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

// If N is the length of t and M is the length of t and assuming M < N
// Time: O(N log M)
// Space: O(M)
public class MinConSub
{
  public static String minSubString(String s, String t)
  {
    if (s == null || t == null || t.length() == 0)
    {
      return null;
    }
    Set<Character> target = new HashSet<Character>();
    for (char c : t.toCharArray())
    {
      target.add(c);
    }
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    Map<Character, Integer> index = new HashMap<Character, Integer>();
    String min = null;
    for (int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);
      if (target.contains(c))
      {
        if (index.containsKey(c))
        {
          q.remove(index.get(c));
        }
        q.add(i);
        index.put(c, i);
        if (index.size() == target.size())
        {
          int j = q.poll();
          index.remove(s.charAt(j));
          if (min == null || min.length() > 1 + i - j)
          {
            min = s.substring(j, i + 1);
          }
        }
      }
    }
    return min;
  }

  public static void main(String[] args)
  {
    if (args.length < 2)
    {
      System.err.println("args: [s] [t]");
      System.exit(1);
    }
    System.out.println(minSubString(args[0], args[1]));
  }
}