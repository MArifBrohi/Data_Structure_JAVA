class AtFirst{
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

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;
            return;
        } 
        newNode.next = head;
        head = newNode;
    }

    public void printList()
    {
        Node currNode = head;
        while(currNode != null)
        {
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args)
    {
        AtFirst list = new AtFirst();

        list.addFirst(12);
        list.addFirst(23);
        list.addFirst(45);
        System.out.println("Adding at first: ");
        list.printList();
    }
}