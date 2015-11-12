package me.sama.problemsolving;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by ksama on 11/3/15.
 */
public class LIS {
  public static void main(String args[]){
    TreeSet<Node> set = new TreeSet<Node>(new NodeComparator());
    int[] input = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    int index = 0;
    for(int i=0; i<input.length-1;i++){

      int current = input[i];
      int next  = input[i+1];
      if(next<current){
        set.add(new Node(index,i-index+1,input[i]));
        index = i+1;
      }

    }
    System.out.println("Programm Ends!!!!!!");
  }

  static class Node {
    int index;
    int count;
    int value;

    public Node(int index, int count, int value) {
      this.index = index;
      this.count = count;
      this.value = value;
    }
  }

  static class NodeComparator implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
      return o1.value-o2.value;
    }
  }
}
