package me.sama.problemsolving;

/**
 * Created by ksama on 11/6/15.
 */
public class PaintJob {

    public int minCost(int[][] costs) {
      int red = costs[0][0];
      int blue = costs[0][1];
      int green = costs[0][1];
      int tempred,tempblue,tempgreen;
      for(int i=1;i<costs.length;i++){
        tempred = costs[i][0]+(blue<green?blue:green);
        tempblue = costs[i][1]+(red<green?red:green);
        tempgreen = costs[i][2]+(red<blue?red:blue);
        red = tempred;
        blue = tempblue;
        green = tempgreen;
      }
      if(red < blue){
        return red<green?red:green;
      } else{
        return blue<green?blue:green;
      }
    }
}
