package me.sama.problemsolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ksama on 11/6/15.
 */
public class PaintHouse {
  public int minCost(int[][] costs) {
    int noOfColors = 2;
    ColorPriceCombo[] top3 = new ColorPriceCombo[noOfColors];
    for(int i=0;i<noOfColors;i++){
      top3[i] = new ColorPriceCombo(0,-1);
    }
     new ColorPriceCombo(0,-1);
    for(int i=0;i<costs.length;i++){
      ColorPriceCombo[] localTop3 = new ColorPriceCombo[noOfColors];
      PriorityQueue<ColorPriceCombo> queue = new PriorityQueue<ColorPriceCombo>(new Comparator<ColorPriceCombo>() {
        @Override
        public int compare(ColorPriceCombo o1, ColorPriceCombo o2) {
          return o1.price-o2.price;
        }
      });
      for(int j=0;j<costs[0].length;j++){
        queue.add(new ColorPriceCombo(costs[i][j],j));
      }
      for(int k=0;k<noOfColors;k++) {
        ColorPriceCombo combo =queue.poll();
        for(int l=0;l<noOfColors;l++){
          if(combo.color != top3[l].color){
           localTop3[k] = new ColorPriceCombo(combo.price+top3[l].price,combo.color);
            break;
          }
        }
      }
      Arrays.sort(localTop3,new Comparator<ColorPriceCombo>() {
        @Override
        public int compare(ColorPriceCombo o1, ColorPriceCombo o2) {
          return o1.price-o2.price;
        }
      });
      for(int m=0;m<noOfColors;m++) {
        top3[m] = localTop3[m] ;
      }
    }

    return top3[0].price;
  }

  public class ColorPriceCombo{
    int price;
    int color;

    public ColorPriceCombo(int price, int color) {
      this.price = price;
      this.color = color;
    }
  }
}
