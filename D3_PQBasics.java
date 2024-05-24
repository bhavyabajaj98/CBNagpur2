import java.util.*;
public class D3_PQBasics {
    public static void main(String[] args) {
        

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(10, 20));

        pq.add(new Pair(30, 40));

        pq.add(new Pair(5, 50));

        Pair p = pq.remove();
        System.out.println(p.i + " " + p.j);        // 5, 50

        p = pq.remove();
        System.out.println(p.i + " " + p.j);

    } 
    
    public static class Pair implements Comparable<Pair>{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        public int compareTo(Pair o){
            return this.j-o.j;
        }
    }
}
