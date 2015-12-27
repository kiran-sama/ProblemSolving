package me.sama.problemsolving;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ksama on 11/21/15.
 */
public class Graph<T> {
    HashMap<T,List<T>> graph = null;

    public Graph(){
      graph = new HashMap<T, List<T>>();
    }

    public void addEdge(T from, T to){
      if(graph.containsKey(from)){
         graph.get(from).add(to);
      } else {
        LinkedList<T> adjacencyList = new LinkedList<T>();
        adjacencyList.add(to);
        graph.put(from, adjacencyList);
      }
      if(!graph.containsKey(to)){
        graph.put(to,new LinkedList<T>());
      }
    }

   public void topologicalSort(){
     Set<T> vertices = graph.keySet();
     Set<T> visited = new HashSet<T>();
     Stack<T> topologocalSort = new Stack<T>();
     for(T vertex:vertices){
       if(!visited.contains(vertex)){
         topologicalSortHelper(vertex, visited, topologocalSort);
       }
     }

     for(T item:topologocalSort){
       System.out.println(item);
     }
   }

  private void topologicalSortHelper(T vertex,Set<T> visited, Stack<T> topologicalSort){
    visited.add(vertex);
    List<T> neighbors = graph.get(vertex);
    for(T neighbor:neighbors){
      if(!visited.contains(neighbor)){
         topologicalSortHelper(neighbor, visited, topologicalSort);
      }
    }
    topologicalSort.add(vertex);


  }

  public static void main(String[] args){
    Graph<Character> graph = new Graph<Character>();
    graph.addEdge('a','b');
    graph.addEdge('a','c');
    graph.addEdge('b','c');
    graph.addEdge('w','e');
    graph.addEdge('w','f');
    graph.addEdge('w','g');


    graph.topologicalSort();
  }

}
