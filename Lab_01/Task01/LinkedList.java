public class LinkedList implements List {

    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {

        if (head == null) {

            System.out.print( "The list is empty: " );
            return true;
        } else {
            System.out.print( "The list is not empty: " );
            return false;
        }
    }

    @Override
    public int size() {
        //System.out.print("The size of the list is: ");
        Node temp = head;
        int count = 0;
        while (temp != null) {

            count++;
            temp = temp.next;

        }

        return count;

    }

    @Override

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null)
                cur = cur.next;

            cur.next = node;

        }

        this.size++;
    }

    public void add(int index, Node node) {
        int size = size();
        if (index > size + 1 || index < 1) {
            System.out.println( "Invalid index" );
        } else if (index == 1) {
            node.next = head;
            head = node;
        } else {
            Node previous = head;
            int count = 1;
            while (count < index - 1) {
                previous = previous.next;
                count++;
            }
            Node cur = previous.next;
            node.next = cur;
            previous.next = node;

        }


    }


    @Override
    public void remove(int index) {

        if (head == null) {
            return;
        }

        Node tmp = head;

        if (index == 0) {
            head = tmp.next;
        }
        int count = 1;
        while (count < index - 1) {

            tmp = tmp.next;
            count++;

        }

        Node cur = tmp.next.next;
        tmp.next = cur;

    }

   /*@Override
    public void remove(Node node) {

       if (head.data == node.data) {
           head = head.next;
       }


       Node cur = head;
       Node remove = null;

       while (cur.next != null && cur.data != node.data) {

           remove = cur;
           cur = cur.next;

       }

            remove.next = cur.next;
   }*/


    @Override
    public List duplicate() {
        LinkedList listDupli = new LinkedList();
        Node tmp = head;
        listDupli.add( tmp );
        return listDupli;

    }

    @Override
    public List duplicateReversed() {
        LinkedList dupRev = new LinkedList();
        Node previous = null;
        Node current = head;
        dupRev.add( current );


        Node next;

        while (current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        dupRev.head = previous;
        return dupRev;

    }

    public String toString() {
        String items = "";
        Node cur = head;
        while (cur.next != null) {
            items += cur.data + ", ";
            cur = cur.next;
        }
        items += cur.next;
        return "[ Size: " + size() + "-" + items + " ]";
    }

    public static void main(String args[]) {

        LinkedList l1 = new LinkedList();

        System.out.println( l1.isEmpty() );

        System.out.println( "The size of the list: " + l1.size() );

        Node node = new Node( 65 );
        Node n1 = new Node( 25 );
        Node n2 = new Node( 35 );
        Node n3 = new Node( 15 );
        Node n4 = new Node( 10 );
        l1.add( node );
        l1.add( n1 );
        l1.add( n2 );
        l1.add( 4, n3 );
        l1.add( 5, n4 );

        System.out.println( l1.isEmpty() );
        System.out.println( "The size of the list: " + l1.size() );

        System.out.println( l1.toString() );
        System.out.print( "The element is removed: " );
        l1.remove( 3 );

        System.out.println( l1.toString() );

        System.out.println( "The duplicated list is: " );
        System.out.println( l1.duplicate() );

        System.out.println( "The reversed duplicated list is: " );
        System.out.println( l1.duplicateReversed() );


    }


}
