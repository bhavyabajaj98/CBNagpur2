import java.util.*;
public class D4_PQBasics {

    public static class Pair implements Comparable<Pair>{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        public int compareTo(Pair o){
            return this.i-o.i;
        }
    }
    public static void main(String[] args) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(10, 20));

        pq.add(new Pair(30, 40));    

        pq.add(new Pair(5, 100));

        Pair p = pq.remove();
        System.out.println(p.i + " " + p.j);     

        // System.out.println(pq.remove());    //5

        // System.out.println(pq.remove());    //10

        // System.out.println(pq.remove());    //20

        
    }    
}
