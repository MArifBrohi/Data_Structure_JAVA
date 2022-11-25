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

public class RecursiveBinaryTree {
    
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

    public Node delete(Node node, int val) {
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
              return null;                           //             5   
            } else {                                 //         3       7 
              return temp;                           //       2   4   6   9

            }
          } else {
            Node successor = getSuccessor(node);
            node.data = successor.data;
            
            node.right = delete(node.right, successor.data);
            return node;
          }
        }
        
        return node;
      }
      public Node getSuccessor(Node node) {
        if(node == null) {
          return null;
        }
        
        Node temp = node.right;
        
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

    static void preOrderTraversal(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    static void postOrderTraversal(Node root){
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
        Node root=null;
        RecursiveBinaryTree tree = new RecursiveBinaryTree();
        int[] arr={5,3,7,2,4,9,6};
        // System.out.println(arr.length);

        for(int key:arr){                        //             5   
            root=insertion(root, key);           //         3       7 
        }                                        //       2   4   6   9

        // System.out.println("Pre-order Traversal: ");
        // preOrderTraversal(root);
        System.out.println("\n");
        System.out.println("In-order Traversal: ");
        inOrderTraversal(root);
        // System.out.println("\n");
        // System.out.println("Post-order Traversal: ");
        // postOrderTraversal(root);
        tree.delete(root,7);
        System.out.println("\nIn-order Traversal: ");
        inOrderTraversal(root);

    }
}
