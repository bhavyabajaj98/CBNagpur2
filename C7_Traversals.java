import java.util.*;
public class C7_Traversals {
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

        // node
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        traversal(node, al, al1, al2);
        System.out.println(al);
        System.out.println(al1);
        System.out.println(al2);
    }    

    public static void traversal(Node node, ArrayList<Integer> al, ArrayList<Integer> al1, ArrayList<Integer> al2){
        if(node == null){
            return;
        }

        // preorder
        al.add(node.val);

        traversal(node.left, al, al1, al2);

        //inorder
        al1.add(node.val);

        traversal(node.right, al, al1, al2);

        // postorder
        al2.add(node.val);
    }


}
