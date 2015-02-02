package me.sama.problemsolving;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by ksama on 1/30/15.
 */
public class InversionCount {
  public static void main(String args[]) throws Exception{
    int[] input = getInputFromFile();
    System.out.println(findInversionCount(input));
  }

  private static int[] getInputFromFile() throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    String line = reader.readLine();
    ArrayList<Integer> inputList = new ArrayList<Integer>();
    while(line != null){
      line = line.trim();
      if(!line.isEmpty()) {
         inputList.add(Integer.parseInt(line));
      }
      line = reader.readLine();
    }
    int[] input = new int[inputList.size()];
    for(int i=0;i<input.length;i++){
      input[i] = inputList.get(i);
    }
     return input;
  }

  private static long findInversionCount(int[] input) {
    return findInversionCountRoutine(input, 0, input.length - 1);
  }

  private static long findInversionCountRoutine(int[] input, int start, int end) {
    if(start >= end)
      return 0;
    int splitIndex = (start + end) / 2;
    long inversionCountOfFirstHalf = findInversionCountRoutine(input, start, splitIndex);
    long inversionCountSecondHalf = findInversionCountRoutine(input, splitIndex + 1, end);
    return inversionCountOfFirstHalf + inversionCountSecondHalf + findSplitInversionCount(input, start, end);
  }

  private static long findSplitInversionCount(int[] input, int start, int end) {
    int splitIndex = (start + end) / 2;
    int firstIndex = start;
    int secondIndex = splitIndex + 1;
    int[] merger = new int[end - start+1];
    int mergeIndex = 0;
    long inversionCount = 0;
    int i;

    while (firstIndex <= splitIndex && secondIndex <= end) {
      if (input[firstIndex] <= input[secondIndex]) {
        merger[mergeIndex++] = input[firstIndex++];
      } else {
        merger[mergeIndex++] = input[secondIndex++];
        inversionCount += splitIndex - firstIndex + 1;
      }
    }
    while (firstIndex <= splitIndex) {
      merger[mergeIndex++] = input[firstIndex++];
    }

    while (secondIndex <= end) {
      merger[mergeIndex++] = input[secondIndex++];
    }

    for (i = 0; i < end - start + 1; i++) {
      input[i + start] = merger[i];
    }

    return inversionCount;
  }
}