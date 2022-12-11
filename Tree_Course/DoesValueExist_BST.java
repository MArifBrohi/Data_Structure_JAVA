class IfNodeExist{
    class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right= null;
        }
    }

    public Node inserNode(Node root , int key){
        if(root == null){
            Node newNode = new Node(key);
            root = newNode;
            return root;
        }
        if(key < root.data){
            root.left = inserNode(root.left, key);
        }
        else if(key > root.data){
            root.right = inserNode(root.right, key);
        }

        return root;
    }

    public boolean doesNodeExist(Node root, int key){

        if(root == null){
            return false;
        }
        if( key == root.data){
            return true;
        }
        
        boolean res1 = doesNodeExist(root.left, key);
        if(res1==true){
            return true;
        }

        boolean res2 = doesNodeExist(root.right, key);
        if(res2 == true){
            return true;
        }
        return false;
      
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void main(String[] args){
        Node root  = null;
        IfNodeExist ob = new IfNodeExist();
        int arr[] = {12,9,16,13,10,5};

        for(int key : arr){
            root = ob.inserNode(root, key);
        }

        ob.preOrder(root);
        System.out.println("\nDoes value exist: "+ 5);
        System.out.println(ob.doesNodeExist(root, 5));
    }
}
