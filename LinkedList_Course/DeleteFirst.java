class DeleteFirst{
    Node head = null;
    class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    //  public void deleteFirst()
    //   {    
    //        if(head == null)
    //        {
    //            System.out.println("The list is empty");
    //            return;
    //        }
    //          head = head.next;
     
    //   }
     

    public void deleteFirst()
    {
        if(head != null)
        {
            Node temp = this.head;
            this.head = this.head.next;
            temp = null;
        }

    }

    public void printList()
    {
        Node cur = head;
        while(cur!=null)
        {
            System.out.print(cur.data+"->");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        DeleteFirst list = new DeleteFirst();

        list.addFirst(12);
        list.addFirst(45);
        list.addFirst(254);

        list.deleteFirst();
        list.printList();
        
    }
}