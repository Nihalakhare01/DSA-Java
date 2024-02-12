package graph2;

import java.util.ArrayList;

// cycle detection detection dfs approach
public class cycledetectiondfs {
    static class Edge{
        int src,dest;

    public Edge(int s, int d){
        this.src = s;
        this.dest = d;
        }
    }

// graph 1
    static void creategraph(ArrayList<Edge> graph[]){  //True - cycle
        for( int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
             graph[0].add(new Edge(0,2));

            //1-vertex
            graph[1].add(new Edge(1,0));

            //2-vertex
            graph[2].add(new Edge(2,3));
    
            //3-vertex
            graph[3].add(new Edge(3,0));

        } 

        // graph 2 - false
    static void creategraph1(ArrayList<Edge> graph[]){  //True - cycle
        for( int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
             graph[0].add(new Edge(0,1));
              graph[0].add(new Edge(0,2));

            //1-vertex
            graph[1].add(new Edge(1,3));

            //2-vertex
            graph[2].add(new Edge(2,3));

        } 


        public static boolean iscycle(ArrayList<Edge>[] graph){
            boolean vis[] = new boolean[graph.length];   
             boolean stack[] = new boolean[graph.length]; 

             for(int i=0; i<graph.length; i++){
                if (!vis[i]) {
                    if (iscycleutil(graph,i,vis,stack)) {
                        return true;
                    }
                }
             }
             return false;
        }

        public static boolean iscycleutil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[] ){
            vis[curr] = true;
            stack[curr] = true;

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if (stack[e.dest]) { //cycle   
                     return true;
                }
                if (!vis[e.dest] && iscycleutil(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
            stack[curr] = false;
            return false;
        }

    public static void main(String[] args) {
         int v = 4;
             ArrayList<Edge> graph[] = new ArrayList[v];
             creategraph(graph);
             System.out.println(iscycle(graph));
              creategraph1(graph);
             System.out.println(iscycle(graph));
    }
}
