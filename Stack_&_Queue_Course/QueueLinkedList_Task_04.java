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
    
//Utility function to remove front element from the queue and check for Queue Underflow
     public static void dequeue()
     {
            Node deQNode = front;
         if(rear == null || front ==  null){
             System.out.println("Queue is underflow");
             return;
         }
       
        else{
          System.out.println("removing "+deQNode.data);
          front = front.next;
          rear = rear.next;
        }
     }
// Utility function to add an item in the queue 
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
// Utility function to return top element in a queue 
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
     // Utility function to check if the queue is empty or not
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
