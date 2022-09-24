import java.util.Scanner;
class DoublyList{

    class Node{
        int data;
        Node next;
        Node pre;

        Node(int data)
        {
            this.data = data;
            next = null;
            next = null; 
        }
    }
    Node head = null;
    Node tail  = null;

    public void inserting()
    {
        int data , n;
        try (Scanner sc = new Scanner(System.in)) {
            do{
                System.out.print("Enter data: ");
                data = sc.nextInt();

                Node newNode = new Node(data);
                if(head ==null)
                {
                    head = newNode;
                    tail = newNode;
                }
                else
                {
                    head.pre = newNode;
                    newNode.next = head;
                    head  = newNode;
                }
                System.out.println("Do you want to print add elements, if yea; press 1");
                n = sc.nextInt();
            }while(n==1);
        }

    }
    public void traverse()
    {
            Node cur = head;
            if(head == null)
            {
                System.out.println("List is empty");
            }
            else{
                while(cur!=null)
                {
                    cur = cur.next;
                }
            }
    }

    public static void main(String[] args)
    {
        DoublyList d_list = new DoublyList();
        d_list.inserting();
        d_list.traverse();
    }
}

   
