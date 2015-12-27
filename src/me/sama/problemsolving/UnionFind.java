package me.sama.problemsolving;


/**
 * Created by ksama on 11/21/15.
 */
public class UnionFind {
  int[] parent;
  int[] weight;

  public UnionFind(int size){
    parent = new int[size];
    weight = new int[size];
    for(int i=0;i<size;i++){
      parent[i] = i;
      weight[i] = 1;
    }
  }

  public int find(int id){
    return parent[id];
  }

  public boolean isConnected(int id1, int id2){
    return parent[id1] == parent[id2];
  }

  public void union(int id1, int id2){
    int id1Root = find(id1);
    int id2Root = find(id2);

    if (id1Root == id2Root)
      return;
    if(weight[id1Root]>weight[id2Root]){
      parent[id2Root] = id1Root;
      weight[id1Root] += weight[id2Root];
    } else {
      parent[id1Root] = id2Root;
      weight[id2Root] += weight[id1Root];
    }
  }



}
