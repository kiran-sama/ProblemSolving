package me.sama.problemsolving;

/**
 * Created by ksama on 11/6/15.
 * abc
 * dabc
 * dbc
 *
 *
 */
public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    int lengthDiff = s.length()-t.length();
    if(lengthDiff >1 || lengthDiff <-1)
      return false;
    else
    {
      if(s.length() ==0 || t.length() ==0){
        if(lengthDiff ==0)
          return false;
        else
          return true;
      }
      int i=0,j=0;
      boolean changeAllowed = true;
      while(i<s.length()&&j<t.length()){
        char sc = s.charAt(i);
        char tc = t.charAt(j);
        if(sc != tc){
          if(changeAllowed) {
            changeAllowed = false;
            if (lengthDiff == 0)
              continue;
            else if (lengthDiff == 1) {
              j--;
              continue;
            } else {
              i--;
              continue;
            }
          }else
            return false;
        }
        i++;
        j++;
      }
      return !changeAllowed;


    }


  }
}
