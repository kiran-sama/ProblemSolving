package me.sama.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksama on 11/5/15.
 */
public class Justifier {
  public static void main(String args[]){
    String[] words ={"sama","kiran","reddy"};
    int maxlength= 11;
    fullJustify(words, maxlength);

  }
    public static void fullJustify(String[] words, int maxWidth) {
      int lineWidth = maxWidth;
      int start =0;
      boolean process = false;
      for(int i=0;i<words.length;i++){
        lineWidth = lineWidth - words[i].length()-1;

        if(lineWidth < -1){
          lineWidth = lineWidth+words[--i].length()+1;
          process = true;
        }
        if(i == words.length-1){
          process = true;
        }
        if(process) {
          ArrayList<String> paddings = getPaddingStrings(i - start - 1 < 1 ? 1 : i - start - 1, maxWidth, lineWidth);
          StringBuffer buf = new StringBuffer();
          int k = 0;
          boolean oneword = true;
          for (int j = start; j < i; j++) {
            oneword =false;
            buf.append(words[j]);
            buf.append(paddings.get(k++));
          }
          buf.append(words[i]);
          if(oneword)
            buf.append(paddings.get(k)) ;
          System.out.println(buf.toString()+"!");
          start = i + 1;
          lineWidth = maxWidth;
          process = false;
        }

      }

    }

    public static ArrayList<String> getPaddingStrings(int gaps, int maxWidth,int lineWidth){
      ArrayList<String> paddings = new ArrayList<String>();

      if(lineWidth == -1){
        for(int i=0;i<gaps;i++){
          paddings.add(" ");
        }
      }else if(lineWidth == 0){
        paddings.add("  ");
        for(int i=1;i<gaps;i++){
          paddings.add(" ");
        }
      }else{
        int value = (maxWidth-lineWidth)/gaps;
        int mod = (maxWidth-lineWidth)/gaps;
        char[] chars = new char[value+1];
        for(int index=0;index<chars.length;index++){
          if(index!=chars.length-1)
            chars[index]=' ';
          else
            chars[index]='\0';

        }
        for(int i=0;i<mod;i++){
          chars[value] = ' ';
          paddings.add(new String(chars));
        }
        chars[chars.length-1]='\0';
        for(int i=mod;i<gaps;i++){
          paddings.add(new String(chars));
        }

      }
      return paddings;
    }
}
