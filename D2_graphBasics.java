import java.util.*;
public class D2_graphBasics {

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

        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            String str = sc.nextLine();

            String[] arr = str.split(" ");          // 3 -> 0, 1, 2

            int u = Integer.parseInt(arr[0]);       // "54", "abc", ""
            int v = Integer.parseInt(arr[1]);
            int wt = Integer.parseInt(arr[2]);

            graph[u].add(new Edge(u, v, wt));
            graph[v].add(new Edge(v, u, wt)); 
        }


        // hasPath
        // int src = sc.nextInt();
        // int dest = sc.nextInt();

        // boolean[] vis = new boolean[vtces];

        // boolean ans = hasPath(src, dest, graph, vis);



        // printAllPaths
        // vis = new boolean[vtces];

        // minWt = Integer.MAX_VALUE;
        // minWtPath = "";

        // maxWt = Integer.MIN_VALUE;
        // maxWtPath = "";

        // ceilWt = Integer.MAX_VALUE;
        // ceilWtPath = "";

        // floorWt = Integer.MIN_VALUE;
        // floorWtPath = "";


        // multisolver(graph, src, dest, vis, src+"", 0, 40);

        // System.out.println("Min : " + minWt + " : " + minWtPath);
        // System.out.println("Max : " + maxWt + " : " + maxWtPath);
        // System.out.println("Ceil : " + ceilWt + " : " + ceilWtPath);
        // System.out.println("Floor : " + floorWt + " : " + floorWtPath);


        // get connected components
        // vis = new boolean[vtces];

        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // ArrayList<Integer> curr = new ArrayList<>();

        // for(int i = 0; i < vtces; i++){
        //     if(vis[i] == false){
                
        //         dfs(graph, i, vis, curr);

        //         list.add(curr);
        //     }
        // }

        // System.out.println(list);

        // bfs
        // int src = sc.nextInt();

        // Queue<P> queue = new ArrayDeque<>();

        // queue.add(new P(src, src+""));

        // boolean[] vis = new boolean[vtces];

        // ArrayList<Integer> list = new ArrayList<>();

        // while(queue.size() > 0){
        //     // r, m*, w, a*

        //     //r
        //     P rem = queue.remove();


        //     // m*
        //     if(vis[rem.src] == true){
        //         continue;
        //     }
        //     vis[rem.src] = true;
            

        //     // w
        //     list.add(rem.src);

        //     // a*
        //     for(Edge t: graph[rem.src]){
        //         if(vis[t.nbr] == false){
        //             queue.add(new P(t.nbr, rem.psf + t.nbr));
        //         }
        //     }
        // }

        // System.out.println(list);

        // boolean[] vis = new boolean[vtces];

        // boolean flag = false;
        // for(int i = 0; i < vtces; i++){
        //     if(vis[i] == false){
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

        // Queue<Pair> queue = new ArrayDeque<>();

        // queue.add(new Pair(src, 1));

        // boolean[] vis = new boolean[vtces];

        // ArrayList<Integer> list = new ArrayList<>();

        // while(queue.size() > 0) {
        //     // r
        //     Pair rem = queue.remove();

        //     // m*
        //     if(vis[rem.src] == true){
        //         continue;
        //     }
        //     vis[rem.src] = true;

        //     // w
        //     if(rem.time <= ref){
        //         list.add(rem.src);
        //     }
        //     else{
        //         break;
        //     }

        //     // a*
        //     for(Edge edge: graph[rem.src]){
        //         if(vis[edge.nbr] == false){
        //             queue.add(new Pair(edge.nbr, rem.time+1));
        //         }
        //     }
        // }

        // System.out.println(list);


        // djiksta
        int src = sc.nextInt();
        int dest = sc.nextInt();

        boolean[] vis = new boolean[vtces];

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(src, src+"", 0));

        while(pq.size() > 0){
            // r
            Triplet rem = pq.remove();

            // m*
            if(vis[rem.src] == true){
                continue;
            }
            vis[rem.src] = true;


            // w
            if(rem.src == dest){
                System.out.println(rem.wsf + " via " + rem.psf);
                break;
            }



            // a*
            for(Edge edge: graph[rem.src]){

                if(vis[edge.nbr] == false){
                    pq.add(new Triplet(edge.nbr, rem.psf+edge.nbr, rem.wsf+edge.wt));
                }
            }
        }

        //

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

    public static class Pair{
        int src;
        int time;

        Pair(int src, int time){
            this.src = src;
            this.time = time;
        }
    }

    public static boolean bfs(ArrayList<Edge>[] graph, int src, boolean[] vis){
        Queue<P> queue = new ArrayDeque<>();

        queue.add(new P(src, src+""));

        while(queue.size() > 0){
            //r
            P rem = queue.remove();

            // m*
            if(vis[rem.src] == true){
                return true;
            }
            vis[rem.src] = true;

            //w

            //a
            for(Edge e: graph[rem.src]){
                if(vis[e.nbr] == false){
                    queue.add(new P(e.nbr, rem.psf+e.nbr));
                }
            }
        }

        return false;
    }

    public static class P{
        int src;
        String psf;

        P(int src, String psf){
            this.src = src;
            this.psf = psf;
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> curr){

        vis[src] = true;
        curr.add(src);
        
        for(Edge e: graph[src]){

            if(vis[e.nbr] == false){
                dfs(graph, e.nbr, vis, curr);
            }
        }
    }

    static int minWt;
    static String minWtPath;

    static int maxWt;
    static String maxWtPath;

    static int ceilWt;
    static String ceilWtPath;

    static int floorWt;
    static String floorWtPath;

    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf, int wsf, int ref){
        if(src == dest){

            // wsf vs minWt
            if(wsf < minWt){
                minWt = wsf;
                minWtPath = psf;
            }

            // wsf vs maxWt
            if(wsf > maxWt){
                maxWt = wsf;
                maxWtPath = psf;
            }

            // wsf vs ceilWt
            if(wsf > ref && wsf < ceilWt){
                ceilWt = wsf;
                ceilWtPath = psf;
            }

            // wsf vs floorWt
            if(wsf < ref && wsf > floorWt){
                floorWt = wsf;
                floorWtPath = psf;
            }

            return;
        }

        vis[src] = true;
        ArrayList<Edge> temp = graph[src];
        for(int i = 0; i < temp.size(); i++){
            Edge e = temp.get(i);

            if(vis[e.nbr] == false){
                multisolver(graph, e.nbr, dest, vis, psf+e.nbr, wsf+e.wt, ref);
            }
        }
        //
        vis[src] = false;

    }

    public static boolean hasPath(int src, int dest, ArrayList<Edge>[] graph, boolean[] vis){
        if(src == dest) return true;


        vis[src] = true;
        ArrayList<Edge> al = graph[src];
        for(int i = 0; i < al.size(); i++){
            Edge t = al.get(i);

            if(vis[t.nbr] == false){
                boolean flag = hasPath(t.nbr, dest, graph, vis);
                if(flag == true){
                    return true;
                }
            }
            
        }

        return false;
    }
}
