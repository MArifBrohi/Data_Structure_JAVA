class DeleteLast{
    Node head;
    class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }
        else{

         Node curNode = head;
         while(curNode.next!=null)
         {
            curNode  = curNode.next;
         }
         curNode.next = newNode;
        }
    }

    public void printList()
    {
        if(head == null)
        {
            System.out.println("List is empty: ");
            return;
        }
        Node cur = head;

        while(cur!=null)
        {
            System.out.print(cur.data+"->");

            cur = cur.next;
        }
        System.out.println("null");
    }

    // delete last Node element 
    public void deleteLast()
    {
            if(head == null)
            {
                System.out.println("list is empty");
                head = null;
                return;
            }
        
            if(head.next == null){
                head = null;
                return;
            }
            
                // traverse to the second last element of the list

                Node secondLast = head;
                Node lastNode = head.next;
                while(lastNode.next != null)
                {
                    lastNode = lastNode.next;
                    secondLast = secondLast.next;  
                    
                }
                secondLast.next = null;
                
            
        }


    public static void main(String [] args)
    {
        DeleteLast list = new DeleteLast();

        list.addLast(12);
        list.addLast(23);
  
        list.addLast(45);
        list.addLast(56);
        list.printList();

        list.deleteLast();
        System.out.println("after deleting last element");
        list.printList();

 
       
    }
}