import java.util.*;
public class C2_BTBasics {

    // public static class Node{
    //     int data;
    //     Node left;
    //     Node right;

    //     // constructor
    //     Node(int data, Node left, Node right){
    //         this.data = data;
    //         this.left = left;
    //         this.right = right;
    //     }
    // }

    public static class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        // Node obj = new Node(5, null, null);
        // obj.left = new Node(10, null, null);


        // Stack
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1, 2));

        Pair obj = new Pair(3, 4);
        stack.push(obj);

        Pair p = stack.peek();
        System.out.println(p.i);
        System.out.println(p.j);

        // stack.push(20);
        // stack.push(30);
        // stack.push(40);
        // stack.push(50);

        // String ans = stack.peek();
        // System.out.println(ans);    // 50

        // int a = stack.pop();
        // System.out.println(a);  
        
        // a = stack.pop();
        // System.out.println(a);

        // a = stack.pop();
        // System.out.println(a);

        // a = stack.pop();
        // System.out.println(a);
        // a = stack.pop();
        // System.out.println(a);

        // a = stack.peek();
        // System.out.println(a);
    }    
}
