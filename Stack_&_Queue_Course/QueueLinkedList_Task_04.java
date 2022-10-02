class Node{

    int data;
    Node next;

    public Node(int data)
    {
        this.data =data;
        next  = null;
  
    }
}
class Queue{
    private static Node rear = null , front = null;
    

     public static void dequeue()
     {
          Node deQNode = front;
    
          System.out.println("removing "+deQNode.data);
          front = front.next;
          rear = rear.next;
     }

    public static void enqueue(int data)
    {
        Node newNode = new Node(data);
        
        if(rear == null)
        {
            rear = front = newNode;
            return;
        }
            
            Node curNode = rear;
            while(curNode.next != null)
            {
                curNode = curNode.next;
                
            }
            curNode.next = newNode;    
    }

    public static int peek()
    {
        return front.data;
    }

    public static void display()
    {
        Node curNode = rear;

        while(curNode!=null)
        {
            System.out.println("inserting "+curNode.data);
            curNode = curNode.next;
        }


    }
    public static boolean isEmpty()
    {
         
        if(rear == null || front == null)
        {
            return true;
        }
        return false;
    }

}
class QueueLinkedList_Task_04{

    public static void main(String[] args)
    {
     
        Queue.enqueue(1);
        Queue.enqueue(2);
        Queue.enqueue(3);
        Queue.display();
        Queue.dequeue();
        System.out.println("top element is "+Queue.peek());
        Queue.dequeue();
         Queue.dequeue();
        
      
        if(Queue.isEmpty())
        {
            System.out.println("queue is empty");
        }
        else{
            System.out.println("queue is not empty");
        }
    }
}