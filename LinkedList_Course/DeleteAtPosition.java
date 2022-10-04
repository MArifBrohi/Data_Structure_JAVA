import javax.swing.text.Position;

class Node{
    int data;
    Node next;

    // Node(int data)
    // {
    //     this.data = data;      /* no need to make constructor if you want these impelementation at line 22 & 23  */
    //     next = null;
    // }
};
class DeleteAtPosition{
    private Node head;

    DeleteAtPosition()
    {
        head = null;
    }

    public void push(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next= null;

        if(head == null)            /* At initial stage head is null and newNode will be assigned to head */
        {
            head = newNode;
            return;
        }
        else{

            Node temp = head;                   /* if head is not null then head will be temp so that head remain safe to avoid data loss */  

            while(temp.next!=null)          /* traverse till temp.next is not null */ 
            {
                temp = temp.next;
            }

            temp.next = newNode;            /* if null then assign new value to temp.next  */
        }
    }


    public void pop(int element)
    {
        if(element<1)
        {
            System.out.println("Delete position must be >= 1");
        }
        else if(element == 1 && head != null)       /* this else if condition is just for deleting 1st element of Node */
        {
            Node deleteNode = head;
            
            head = head.next;

            deleteNode = null;
        }
        else
        {
            Node temp = new Node();
            temp = head;
            for(int i =1; i<(element-1); i++)
            {
                temp = temp.next;
            }
            if(temp!=null && temp.next!=null)
            {
                Node nodeDelete = temp.next;
                temp.next = temp.next.next;

                nodeDelete = null;


            }
            else
            {
                System.out.println("is empty: ");
            }

        }
       
    }

    public void printList()
    {
        if(head == null)
        {
            System.out.println("list is empty");
        }
        else{

            Node curNode = head;
            while(curNode!=null)
            {
                System.out.print(curNode.data+"-> ");
                curNode = curNode.next;
            }
            System.out.println("null");

        }
    }







    public static void main(String[] args)
    {
        DeleteAtPosition list = new DeleteAtPosition();

        list.push(12);
        list.push(13);
        list.push(14);
        list.push(15);
        list.push(16);
        list.push(17);
        list.printList();
        list.pop(5);
        list.printList();
    }

}