package graphSupplemental;

import java.util.ArrayList;

// articulation point tarjans algorithm
public class ariculation {
     static class Edge{
        int src,dest;

    public Edge(int s, int d){
        this.src = s;
        this.dest = d;
        }
    }

    static void creategraph(ArrayList<Edge> graph[]){  //True - cycle
        for( int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

       graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

       graph[2].add(new Edge(2,0));
       graph[2].add(new Edge(2,1));
    
       graph[3].add(new Edge(3,0));
       graph[3].add(new Edge(3,4));
     //   graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
    //   graph[4].add(new Edge(4,5));

    }

    //O(V+E)
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean vis[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

    for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i); //e.src - e.dest
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            } else if (vis[neigh]) { 
                low[curr] = Math.min(low[curr], low[neigh]);
              }  else{
                dfs(graph, neigh, curr, dt, low, time, vis);    
                    low[curr] = Math.min(low[curr], dt[neigh]);
                    if (par != -1 && dt[curr] <= low[neigh]) {
                        System.out.println("AP :"+curr);
                    }
                    children++;
                }
            }
            if (par == -1 && children > 1) {
                System.out.println("Ap:"+curr);
            }
    }

    public static void getap(ArrayList<Edge> graph[], int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        int time =0;
        boolean vis[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(graph, i,-1,dt,low,time,vis);
        }
    }
}

        public static void main(String[] args) {
            int v=5;
            ArrayList<Edge> graph[] = new ArrayList[v];
            creategraph(graph);
           getap(graph, v);
        }
}
