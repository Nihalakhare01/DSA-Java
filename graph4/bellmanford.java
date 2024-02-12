package graph4;

import java.util.ArrayList;

public class bellmanford {
    static class Edge{
        int src,dest,wt;

    public Edge(int s, int d , int w){
        this.src = s;
        this.dest = d;
        this.wt = w;
        }
    }
    
    //Edge[]
    static void creategraph1(ArrayList<Edge> graph[]){  //True - cycle
        for( int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

       graph[1].add(new Edge(1,2,-4));
    //    graph[1].add(new Edge(1,2,1));

       graph[2].add(new Edge(2,3,2));
    
       graph[3].add(new Edge(3,4,4));
    
       graph[4].add(new Edge(4,1,-1));
    //    graph[4].add(new Edge(4,5,5));

    }

     static void creategraph2(ArrayList<Edge> graph){  //True - cycle

        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
       graph.add(new Edge(1,2,-4));
       graph.add(new Edge(2,3,2));
       graph.add(new Edge(3,4,4));
       graph.add(new Edge(4,1,-1));
    }

        public static void bellmanford(ArrayList<Edge> graph, int src, int V){
            int dist[] = new int[V];
            for(int i=0; i<dist.length; i++){
                if (i != src) {
                    dist[i] = Integer.MAX_VALUE;
                }
            }

            //O(VE)
            //algo - O(V)
            for(int i=0; i<V-1; i++){
                //edges - O(E)
                for(int j=0; j<graph.size(); j++){
                        Edge e = graph.get(j);

                        // u,v,wt
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;

                        //relaxatiopn
                        if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])  {
                            dist[v] = dist[u] + wt;
                        }
                    }
                }

            //print
            for(int i=0; i<dist.length; i++){
                System.out.print(dist[i]+" ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int v = 5;
                //ArrayList<Edge> graph[] = new ArrayList[v];
                ArrayList<Edge> graph = new ArrayList<>();
                creategraph2(graph);
                bellmanford(graph, 0,v);
        }
}
