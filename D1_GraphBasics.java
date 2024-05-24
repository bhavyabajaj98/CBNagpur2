import java.util.*;
public class D1_GraphBasics {


    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vtces = Integer.parseInt(sc.nextLine());        
        int e = Integer.parseInt(sc.nextLine());        

        ArrayList<Integer> al = new ArrayList<>();
        //
        ArrayList<Edge>[] graph = new ArrayList[vtces];   //
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }


        for(int i = 0; i < e; i++){
            String str = sc.nextLine();                     //

            String[] arr = str.split(" ");
            int u = Integer.parseInt(arr[0]);     // "67", "abc", ""
            int v = Integer.parseInt(arr[1]);
            int wt = Integer.parseInt(arr[2]);

            graph[u].add(new Edge(u, v, wt));
            graph[v].add(new Edge(v, u, wt));
        }

        // hasPath
        // int src = sc.nextInt();
        // int dest = sc.nextInt();
        // boolean[] vis = new boolean[vtces];             // graph.length
        // String str = "0";

        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // ArrayList<Integer> curr = new ArrayList<>();
        // printAllPaths(graph, src, dest, vis, list, curr);
        // System.out.println(list);

        // smallest path
        // boolean[] vis = new boolean[vtces];

        // int[] arr = new int[4];
        // arr[0] = Integer.MIN_VALUE;
        // arr[1] = Integer.MAX_VALUE;
        // arr[2] = Integer.MAX_VALUE;
        // arr[3] = Integer.MIN_VALUE;

        // String[] strarr = new String[4];

        // multisolver(graph, 0, 6, vis, 0, "0", arr, strarr, 45);
        
        // System.out.println("MaxWt : " + arr[0] + ", Path : " + strarr[0]);
        // System.out.println("MinWt : " + arr[1] + ", Path : " + strarr[1]);
        // System.out.println("CeilWt : " + arr[2] + ", Path : " + strarr[2]);
        // System.out.println("FloorWt : " + arr[3] + ", Path : " + strarr[3]);


        // get connected components
        // vis = new boolean[vtces];
        

        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // for(int i = 0; i < vtces; i++){         // i < graph.length
        //     if(vis[i] == false){
        //         ArrayList<Integer> curr = new ArrayList<>();
        //         dfs(i, graph, vis, curr);
        //         // ans.add(curr);      //
        //         ans.add(new ArrayList<>(curr));
        //     }
            
        // }

        // System.out.println(ans);


        // bfs
        // boolean flag = false;
        // boolean[] vis = new boolean[vtces];
        // for(int i = 0; i < vtces; i++){
        //     if(vis[i] == false){                //
        //         flag = bfs(graph, i, vis);
        //         if(flag == true){
        //             break;
        //         }
        //     }
        // }
        
        // System.out.println(flag);

        // spread of infection
        // int src = sc.nextInt();
        // int ref = sc.nextInt();

        // Queue<P> queue = new ArrayDeque<>();
        // queue.add(new P(src, 1));

        // boolean[] vis = new boolean[vtces];

        // ArrayList<Integer> list = new ArrayList<>();

        // while(queue.size() > 0){
        //     // r
        //     P rem = queue.remove();

        //     // m*
        //     if(vis[rem.src] == true){
        //         continue;
        //     }
        //     vis[rem.src] = true;

        //     // w
        //     if(rem.time <= ref){
        //         list.add(rem.src);
        //     }
        //     else {
        //         break;
        //     }

        //     // a*
        //     for(Edge edge: graph[rem.src]){
        //         if(vis[edge.nbr] == false){
        //             queue.add(new P(edge.nbr, rem.time+1));
        //         }
        //     }
        // }

        // System.out.println(list);


        // dijkstra
        int src = sc.nextInt();
        int dest = sc.nextInt();

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(src, src+"", 0));

        boolean[] vis = new boolean[vtces];

        while(pq.size() > 0){
            // r
            Triplet curr = pq.remove();
            int s = curr.src;
            String psf = curr.psf;
            int wsf = curr.wsf;

            // m*
            if(vis[s] == true){
                continue;
            }
            vis[s] = true; 

            //w
            if(s == dest){
                System.out.println(wsf + " via " + psf);
                break;
            }

            //a
            for(Edge edge: graph[s]){
                int nbr = edge.nbr;
                int wt = edge.wt;
                if(vis[nbr] == false){
                    pq.add(new Triplet(nbr, psf+nbr, wsf+wt));
                }
            }
        }

        


    } 

    public static class Triplet implements Comparable<Triplet>{
        int src;
        String psf;
        int wsf;

        Triplet(int src, String psf, int wsf){
            this.src = src;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Triplet o){
            return this.wsf-o.wsf;
        }

    }

    public static class P{
        int src;
        int time;

        P(int src, int time){
            this.src = src;
            this.time = time;
        }
    }

    public static boolean bfs(ArrayList<Edge>[] graph, int src, boolean[] vis){

        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src, src+""));

        while(queue.size() > 0){
            // r, m*, w, a*

            // r
            Pair rem = queue.remove();

            // m*
            if(vis[rem.src] == true){
                return true;
            }
            vis[rem.src] = true;

            // w
            // System.out.print(rem.src + " ");

            // a*
            for(Edge edge: graph[rem.src]){
                if(vis[edge.nbr] == false){
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }

        return false;
    }

    public static class Pair{
        int src;
        String psf;

        Pair(int src, String psf){
            this.src = src;
            this.psf = psf;
        }
    }

    public static void dfs(int src, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> curr){

        vis[src] = true;
        curr.add(src);
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false){
                dfs(e.nbr, graph, vis, curr);
            }
        }
    }
    
    
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, int wsf, String psf, int[] arr, String[] strarr, int ref){
        if(src == dest){
            // maxwt
            if(wsf > arr[0]){
                arr[0] = wsf;
                strarr[0] = psf;
            }

            // minwt
            if(wsf < arr[1]){
                arr[1] = wsf;
                strarr[1] = psf;
            }

            // ceil
            if(wsf > ref && wsf < arr[2]){
                arr[2] = wsf;
                strarr[2] = psf;
            }

            // floor
            if(wsf < ref && wsf > arr[3]){
                arr[3] = wsf;
                strarr[3] = psf;
            }
            
            return;
        }

        vis[src] = true;
        for(Edge e: graph[src]){

            if(vis[e.nbr] == false){
                //call
                multisolver(graph, e.nbr, dest, vis, wsf+e.wt, psf+e.nbr, arr, strarr, ref);
            }
        }
        vis[src] = false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> curr){
        if(src == dest) {
            curr.add(src);

            // list.add(curr);                          // shallow copy
            list.add(new ArrayList<>(curr));            // deep copy

            curr.remove(curr.size()-1);
            return;
        }

        vis[src] = true;
        curr.add(src);
        for(Edge t: graph[src]){

            if(vis[t.nbr] == false){
                printAllPaths(graph, t.nbr, dest, vis, list, curr);
            }
        }
        vis[src] = false;
        curr.remove(curr.size()-1);
    }
}
