package me.sama.problemsolving;


import javafx.geometry.Pos;

/**
 * Created by ksama on 10/7/15.
 */
public class MatrixPathFinder {
  static char[][] chars= {{'A','B','C','D'},
      {'E','F','G','H'},
      {'I','J','K','L'},
      {'M','N','O','P'}
  };
  public static void main(String[] args){
       System.out.println(hasPath("EGJKOP".toCharArray()));
  }

  public static boolean hasPath(char[] word){
    Position start = searh(word[0]);
    if(start == null){
      return false;
    }else{
      return searchNeighbors(word,1,start);
    }
  }

  public static boolean searchNeighbors(char[] word,int index,Position current){
    if(current.x>3 || current.x <0 || current.y>3 || current.y <0 )
      return false;
    if(index >= word.length)
      return true;
    if(current.x+1< 4 && word[index] == chars[current.x+1][current.y] && searchNeighbors(word,index+1,new Position(current.x+1,current.y)))
      return true;
    if(current.x-1>-1 && word[index] == chars[current.x-1][current.y] && searchNeighbors(word,index+1,new Position(current.x-1,current.y)))
      return true;
    if(current.y+1< 4 && word[index] == chars[current.x][current.y+1] && searchNeighbors(word,index+1,new Position(current.x,current.y+1)))
      return true;
    if(current.y-1>-1 && word[index] == chars[current.x][current.y-1] && searchNeighbors(word,index+1,new Position(current.x,current.y-1)))
      return true;

    return false;
  }

  public static Position searh(char ch){
     for(int i=0;i<4; i++){
       for(int j=0;j<4;j++){
         if(ch == chars[i][j]){
           return new Position(i,j);
         }
       }
     }
    return null;
  }

  private static class Position{
    int x, y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


}
