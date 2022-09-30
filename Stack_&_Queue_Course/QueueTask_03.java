import java.util.*;
class Queue{
    private int arr[];
    private int front;
    private int rear;
    private int capacity;
    private int count;

    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front =0;
        rear = 0;
        count = 0;

    }
    public void deQueue()
    {
        if(rear == front)
        {
            System.out.println("Queue is empty");
            return ;
        }
        System.out.println("removing "+arr[front]);
        for(int i = 0; i<rear-1; i++)
        {
         
            arr[i] = arr[i+1];
  
        }
        rear--;
        --count;
    }
    public void enQueue(int data)
    {
        if(capacity == rear)
        {
            System.out.println("Queue is full");
            return;
        }
        else{
            arr[rear] = data;
            System.out.printf("inserting %d\n",arr[rear]);
            count++;
            rear++;
        }
    }
    public int peek()
    {
        if(rear == front)
        {
            System.out.println("Queue is empty");
            
        }
    
        return arr[front];

    }
    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        if(rear==0 && front==0)
        {
            return true;
        }
        return false;
    }


}
class QueueTask_03{
    public static void main(String []args)
    {
        Queue q = new Queue(4);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println("front element is "+ q.peek());
        q.deQueue();
        System.out.println("front element is "+ q.peek());
        System.out.println("Queue size is "+q.size());
        q.deQueue();
        q.deQueue();
        if(q.isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println("Queue is not empty");
        }
       
      
    }
}