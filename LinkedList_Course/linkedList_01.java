class linkedList{
    Node head;
    class Node{
        String data;
        Node next;

        Node(String data)
        {
            this.data = data;
            next= null;
        }
    }

    /* adding elements in front of list */
    public void addFirst(String data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head  = newNode;
    }

    /* adding elements last of the list */

    public void addLast(String data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }
        Node curNode = head;
        while(curNode.next!=null)
        {
            curNode = curNode.next;
        }
        curNode.next = newNode;

    }
    /* Method for printring list */
    public void printList()
    {
        
        if(head==null)
        {
            System.out.println("Empty List: ");
        }
        Node crrNode = head;
         
        while(crrNode!=null)
        {
            System.out.print(crrNode.data+"->");
             crrNode = crrNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        linkedList list = new linkedList();
        list.addFirst("list");
        list.addFirst("is");
        list.addFirst("This");

        list.printList();
        System.out.println("After adding in last");
        list.addLast("Created");
        list.addLast("by");
        list.addLast("Arif");

        list.printList();

    }
}
