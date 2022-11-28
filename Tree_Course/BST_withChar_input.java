import java.util.Scanner;


class Node{
    char data;
    Node left;
    Node right;

    Node(char str){
        this.data = str;
        left = right = null;
    }
}
class RecursiveBinaryTree_02{

    public static Node insertChar(Node root , char ch){
        if(root == null){
            root = new Node(ch);
            return root;
        }
        else{
            if(ch < root.data){
                root.left = insertChar(root.left, ch);
            }else{
                root.right = insertChar(root.right, ch);
            }
        }
        return root;
    }

    public static Node deleteCharacter(Node root , char ch){
        try {
            if(root == null)
                 return root;
        } catch (Exception e) {
            // TODO: handle exception
                System.out.println("No tree found: ");
        }
        if(ch < root.data){
            root.left = deleteCharacter(root.left, ch);
        }
        else if(ch > root.data) {
            root.right = deleteCharacter(root.right, ch);
        }
        else if(root.left == null || root.right == null){
            Node temp = root.left != null ? root.left : root.right;
            
            if(temp == null){
                return temp;
            }
            else{
                return temp;
            }
        }
        /* deletion in between of tree,  */
        else{
            Node temp = getSuccessor(root);
                
            root.data = temp.data;
            root.right = deleteCharacter(root.right, temp.data);
            return root;
           
        }
        return root;
    }
    public static Node getSuccessor(Node node) {
        if(node == null) {
          return null;
        }
        
        Node temp = node.right;
       // System.out.println("Node.right: "+temp.data);
        
        while(temp.left != null) {
          temp = temp.left;
        }
        
        return temp;
      }

    public static void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }
    public static void preOder(Node node){
        if(node != null){
            System.out.print(node.data+" ");
            preOder(node.left);
            preOder(node.right);
        }
    }
    public static void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+" ");
        }
    }


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write any letter: ");
        String str = sc.next();

        char character[] = str.toCharArray();
        
        Node root = null;
        for(char ch : character){
            root = insertChar(root,ch);
        }
        System.out.println("Do you want to delete any character: Y || N");
        char choice_2 = sc.next().charAt(0);
        switch(choice_2){
            case 'Y':
                System.out.println("Character you want to delete: ");
                char characterToDelete = sc.next().charAt(0);
                deleteCharacter(root, characterToDelete);
                break;
            case 'N':
                System.out.println("OK, No problem...");
                break;
            default:
                System.out.println("Your choice is wrong, dear user...");
        }
        System.out.println("Enter 1: preOrder Traversal: " );
        System.out.println("Enter 2: inOder Traversal: ");
        System.out.println("Enter 3: postOrder Traversal: ");
        System.out.println("==================YOUR CHOICE==================");
        System.out.println("Press: ");
        int choice_1 = sc.nextInt();
        switch(choice_1){
            case 1: 
                System.out.println("Your Expected Output: ");
                preOder(root);
                    break;
            case 2:
                System.out.println("Your Expected Output: ");
                inOrder(root);
                    break;
            case 3: 
                System.out.println("Your Expected Output: ");
                postOrder(root);
                    break;
            default:
                System.out.println("Your choice is wrong, dear user...");
        }
    }
}
