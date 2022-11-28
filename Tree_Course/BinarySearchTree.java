class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

public class RecursiveBinaryTree_01 {
    
    static Node insertion(Node root,int key){
        
        if(root==null){
            Node newNode=new Node(key);
            root=newNode;
            return root;
        }

        else{
            if(key>root.data)
                root.right=insertion(root.right, key);
            else
                root.left=insertion(root.left, key);
        }

        return root;
    }

    public static void searchNode(Node node, int ele){
        if(node == null){
            System.out.println("null tree exception: ");
        }
        else if(ele == node.data){
            System.out.println("Value found: "+node.data);
            return;
        }else{
            if(ele < node.data){
               searchNode(node.left, ele);
            }else{
                 searchNode(node.right, ele);
            }

        }
        System.out.println("Value not found:");
        
        
    }
    public static Node delete(Node node, int val) {
        if(node == null) {
          return node;
        }
        
        if(val < node.data) {
          node.left = delete(node.left, val);
        } else if(val > node.data) {
          node.right = delete(node.right, val);
        } else {
          if(node.left == null || node.right == null) {
            Node temp = node.left != null ? node.left : node.right;
    
            if(temp == null) {
              return null;                           //               5   
            } else {                                 //                 10 
              return temp;                           //               7 
                                                    //              6   9
              

            }
          }
           else {                         // 9
            Node successor = getSuccessor(node);
                //successor = 9
            // System.out.println("successor.data "+successor.data);

            //    System.out.println("node.data "+node.data);
            // node.data = 7
            node.data = successor.data;
          //  node.data = 9
                            //   ( null   ,  9)
            node.right = delete(node.right, successor.data);
            return node;
          }
        }
        
        return node;
      }
      public static Node getSuccessor(Node node) {
        if(node == null) {
          return null;
        }
        
        Node temp = node.right;
        //temp  = 9
       // System.out.println("Node.right: "+temp.data);
        
        while(temp.left != null) {
          temp = temp.left;
        }
        
        return temp;
      }

    static void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
    }

    // static void preOrderTraversal(Node root){
    //     if(root!=null){
    //         System.out.print(root.data+" ");
    //         preOrderTraversal(root.left);
    //         preOrderTraversal(root.right);
    //     }
    // }

    // static void postOrderTraversal(Node root){
    //     if(root!=null){
    //         postOrderTraversal(root.left);
    //         postOrderTraversal(root.right);
    //         System.out.print(root.data+" ");
    //     }
    // }

    public static void main(String[] args) {
        Node root=null;
       // RecursiveBinaryTree tree = new RecursiveBinaryTree();
        int[] arr={5,10,7,6,9};
        // System.out.println(arr.length);

        for(int key:arr){                        //               5   
            root=insertion(root, key);           //                 10 
        }                                        //               7
                                                 //             6   9  

        // System.out.println("Pre-order Traversal: ");
        // preOrderTraversal(root);
        System.out.println("\n");
        System.out.println("In-order Traversal: ");
        inOrderTraversal(root);
        // System.out.println("\n");
        // System.out.println("Post-order Traversal: ");
        // postOrderTraversal(root);
        delete(root,7);
        System.out.println("\nIn-order Traversal: ");
        inOrderTraversal(root);
        // System.out.println("Search Element: ");
        // delete(root, 3);

    }
}
