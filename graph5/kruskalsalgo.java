package graph5;

import java.util.ArrayList;
import java.util.*;

public class kruskalsalgo {
    static class Edge implements Comparable<Edge> {
            int src,dest,wt;
            public Edge(int s, int d, int w) { 
                    this.src = s;
                    this.dest = d;
                    this.wt = w;
            }  
            
            @Override
            public int compareTo(Edge e2){
                return this.wt - e2.wt;
            }
         }

        static void creategraph(ArrayList<Edge> edge){  
                //edges
        edge.add(new Edge(0,1,10));
        edge.add(new Edge(0,2,15));
       edge.add(new Edge(0,3,30));
       edge.add(new Edge(1,3,40));
       edge.add(new Edge(2,3,50));
    }

        static int n = 4; // vertices
        static int par[] = new int[n];
        static int rank[] = new int[n];

        public static void init() {
            for (int i=0;i < n ; i++) {
                par[i] = i;
            }
        }

        public static int find(int x){
            if (par[x] == x) {
                    return x;
            }
            return par[x] = find(par[x]);
        }

        public static void union (int a, int b){
            int parA = find(a);
            int parB = find(b);

            if (rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
            }else if (rank[parA] < rank[parB]) {
                par[parA] = parB;
            }else{
                par[parB] = parA;
            }
        }

        public static void kruskalsMST(ArrayList<Edge> edges, int v){
            init();
            Collections.sort(edges);
            int mstcost = 0;
            int count = 0;

            for(int i=0; count<v-1; i++){  //O(V)
                Edge e = edges.get(i);
                //(src, dest, wt)

                int parA = find(e.src); //src = a
                int parB = find(e.dest); //dest = b
                if (parA != parB) {
                    union(e.src, e.dest);
                    mstcost += e.wt;
                    count++;
                }
            }
            System.out.println(mstcost);
        }

        public static void main(String[] args) {
            int v = 4;
            ArrayList<Edge> edges = new ArrayList<>();
            creategraph(edges);
            kruskalsMST(edges, v);
        }
}
