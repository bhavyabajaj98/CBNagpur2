import java.util.*;
public class C5_Traversals {

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


        // node
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        ArrayList<Integer> al3 = new ArrayList<>();
        traverse(node, al1, al2, al3);
        System.out.println(al1);
        System.out.println(al2);
        System.out.println(al3);

        int val = sc.nextInt();
        // System.out.println(find(node, val));

        ArrayList<Integer> al = new ArrayList<>();
        nodeToRootPath(node, val, al);
        System.out.println(al);


        // level order traversal
        levelOrder(node);

        System.out.println("---------------------");
        // print K levels Down
        print(node, 3);
    }

    public static void print(Node node, int k){
        if(node == null) return;
        if(k == 0) {
            System.out.println(node.data);
            return;
        }
        
        print(node.left, k-1);
        print(node.right, k-1);

    }

    public static void levelOrder(Node node){
        System.out.println("--------------------");
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(queue.size() > 0){
            int sz = queue.size();

            for(int i = 0; i < sz; i++){
                // r, p, a
                Node temp = queue.remove();

                System.out.print(temp.data + " ");

                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }

            System.out.println();
        }
    }

    // public static boolean find(Node node, int val){
    //     if(node == null) return false;

    //     if(node.data == val) return true;

    //     boolean flag1 = find(node.left, val);
    //     if(flag1 == true) return true;

    //     boolean flag2 = find(node.right, val);
    //     if(flag2 == true) return true;


    //     return false;
    // }

    public static boolean nodeToRootPath(Node node, int val, ArrayList<Integer> al){
        if(node == null) return false;

        if(node.data == val){
            al.add(node.data);
            return true;
        } 

        boolean flag1 = nodeToRootPath(node.left, val, al);
        if(flag1 == true){
            al.add(node.data);
            return true;
        }

        boolean flag2 = nodeToRootPath(node.right, val, al);
        if(flag2 == true){
            al.add(node.data);
            return true;
        } 


        return false;
    }

    public static void traverse(Node node, ArrayList<Integer> al1, ArrayList<Integer> al2, ArrayList<Integer> al3){
        if(node == null) return;

        // preorder
        al1.add(node.data);

        traverse(node.left, al1, al2, al3);

        // inorder
        al2.add(node.data);

        traverse(node.right, al1, al2, al3);

        //post order
        al3.add(node.data);

    }

}
