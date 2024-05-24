import java.util.*;
public class C4_BtBasics {

    public static class Node{
        int val;
        Node left;
        Node right;

        //constructor
        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1, null, null);

        node.left = new Node(2, null, null);
        node.right = new Node(3, null, null);

        node.left.left = new Node(4, null, null);
        node.left.right = new Node(5, null, null);

        node.right.left = new Node(7, null, null);
        node.right.right = new Node(8, null, null);

        node.left.right.left = new Node(6, null, null);
        node.right.left.right = new Node(9, null, null);

        // sum
        int ans = sum(node);
        System.out.println(ans);

        // size
        int a = size(node);
        System.out.println(a);

        // max
        int m = max(node);
        System.out.println(m);

        // height
    }    

    public static int max(Node node){
        if(node == null) return Integer.MIN_VALUE;

        int lmax = max(node.left);
        int rmax = max(node.right);

        int ans = node.val;
        if(lmax > ans){
            ans = lmax;
        }
        if(rmax > ans){
            ans = rmax;
        }

        return ans;
    }

    public static int size(Node node){
        if(node == null) return 0;

        return size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node){
        if(node == null) return 0;

        int lsum = sum(node.left);
        int rsum = sum(node.right);

        return lsum + rsum + node.val;
    }

}
