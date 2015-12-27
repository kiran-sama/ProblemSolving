package me.sama.problemsolving;

/**
 * Created by ksama on 11/24/15.
 */
public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    int[] unionfind = new int[n];
    int unionCount =0;
    for(int i=0;i<n;i++){
      unionfind[i] = i;
    }
    for(int i=0;i<edges.length;i++){
      int source = edges[i][0];
      int destination = edges[i][1];
      if(find(unionfind, source)==find(unionfind,destination))
        return false;
      union(unionfind,source,destination);
      unionCount++;
    }
    if(unionCount==n-1)
      return true;
    else
      return false;
  }


  public int find(int[] unionfind,int label){
    while(!(unionfind[label]==label)){
      label=unionfind[label];
    }
    return label;
  }

  public void union(int[] unionfind,int source,int destination){
    unionfind[find(unionfind,destination)]=unionfind[find(unionfind,source)];
  }

  public static void main(String[] args){
    int n =5;
    int[][] edges = {{0,1},{2,1},{2,0},{2,4}};
    System.out.println(new GraphValidTree().validTree(n,edges));
  }
}