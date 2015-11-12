package me.sama.problemsolving;

/**
 * Created by ksama on 10/13/15.
 */
public class MaxPointsInALine {
  public void maxPoints(Point[] points) {
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {

      }
    }
  }


  private static class Point{
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }

    @Override
    public int hashCode() {
      return (String.valueOf(x)+","+String.valueOf(y)).hashCode();
    }

    public boolean equals(Point obj) {
      if(x==obj.x && y==obj.y){
        return true;
      } else{
        return false;
      }
    }
  }

}
