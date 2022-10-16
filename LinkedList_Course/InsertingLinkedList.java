class InsertAtSpePos{

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    static Node GetNode(int data) {
        return new Node(data);
    }

    public static void printList(Node node) {
        Node newNode = node;
        while(newNode!=null)
        {
            System.out.print(newNode.data+"->");

            newNode = newNode.next;
        }
        System.out.println("null");
       
    }


    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(13);
        head.next.next = new Node(67);
        head.next.next.next = new Node(11);

        printList(head);
    }

}
