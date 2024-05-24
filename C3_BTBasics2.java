import java.util.*;
public class C3_BTBasics2 {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Integer[] arr = {1, 2, 4, null, null, 5, 6, null, null, null, 3, 7, null, 9, null, null, 8, null, null};

        Node node = new Node(arr[0], null, null);
        int idx = 1;

        Stack<Pair> stack = new Stack<>();
        Pair p = new Pair(node, 0);
        stack.push(p);

        while(stack.size() > 0){
            Pair p1 = stack.peek();     // node, state

            if(p1.state == 0){      // lc
                if(arr[idx] == null){
                    idx++;
                    p1.state++;
                }
                else{           // arr[idx] != null
                    //1
                    Node temp = new Node(arr[idx], null, null);
                    //2
                    p1.node.left = temp;
                    //3
                    idx++;
                    //4
                    p1.state++;
                    //5
                    Pair p2 = new Pair(temp, 0);
                    stack.push(p2);
                }
            }
            else if(p1.state == 1){     // rc
                if(arr[idx] == null){
                    idx++;
                    p1.state++;
                }
                else{           // arr[idx] != null
                    //1
                    Node temp = new Node(arr[idx], null, null);
                    //2
                    p1.node.right = temp;
                    //3
                    idx++;
                    //4
                    p1.state++;
                    //5
                    Pair p2 = new Pair(temp, 0);
                    stack.push(p2);
                }
            }
            else{           // 2
                stack.pop();
            }
        }

        // display
        display(node);

        // size
        System.out.println(size(node));

        // sum
        System.out.println(sum(node));

        // max
        System.out.println(max(node));

        // height
        System.out.println(height(node));
    }    

    public static int height(Node node){
        if(node == null) return -1; 

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static int max(Node node){
        if(node == null) return Integer.MIN_VALUE;

        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }
    public static int sum(Node node){
        if(node == null) return 0;

        return sum(node.left) + sum(node.right) + node.data;
    }

    public static int size(Node node){
        if(node == null) return 0;

        return size(node.left) + size(node.right) + 1;
    }

    public static void display(Node node){
        if(node == null) return;

        if(node.left != null){
            System.out.print(node.left.data);
        }
        else{
            System.out.print("null");
        }
        
        System.out.print(" -> " + node.data + " <- ");

        if(node.right != null){
            System.out.print(node.right.data);
        }
        else{
            System.out.print("null");
        }

        System.out.println();

        display(node.left);
        display(node.right);
    }
}
