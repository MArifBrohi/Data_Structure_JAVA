class CycleDetection_Task_03{
    Node head;
    class Node
    {
        int data;

        Node next;

        Node(int data)
        {
            this.data =data;
            next = null;
        }
    }
    CycleDetection_Task_03()
    {
        head = null;
    }



    public void push(int data)
    {
        Node newNode = new Node(data);
        
            if(head == null)
            {
                head = newNode;
                return;
            }
            else{

                Node temp = head;
                while(temp.next!=null)
                {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        
    }
    public void printList()
    {
        if(head ==  null)
        {
            System.out.println("list is empty: ");
        }
        else{

            Node cur = head;

            while(cur!=null)
            {
                System.out.print(cur.data+"->");
                cur = cur.next;
            }
            System.out.println("null");
            
        }
       Node cur = head;

        while(cur==head)
        {
            System.out.println("cycle detected: ");
            cur = cur.next;
            return;
        }
        System.out.println("Cycle not detected: ");
        
   
    }

    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        CycleDetection_Task_03 list = new CycleDetection_Task_03();
        System.out.println("is list empty: "+list.isEmpty());
        list.push(12);
        list.push(34);
        list.push(56);
        list.push(57);
        list.push(51);
        list.printList();
        System.out.println("is list empty: "+list.isEmpty());

    }

   
}