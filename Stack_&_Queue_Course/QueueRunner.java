
class Queue{
    private static int rear , front , capacity;
    
   private static int queue[];
    
    Queue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue =new int[capacity];
    }
    
    /* adding elements in queue */
    public void Enquque(int data)
    {
        if(capacity == rear)
        {
            System.out.println("Queue is Full:");
            return;
        }
        else{
            queue[rear] = data;
            rear++;
        }
        return;
    }

    /*remove elements  */

    public void deQueue()
    {
        if(rear==front)
        {
            System.out.println("queue is empty");
        }

        //traverse all elements to left side (front)
        for(int i = front ; i<rear-1; i++)
        {
            queue[i] = queue[i+1];

        }
        rear--;
    }
    /* display elements of queue */

    public void display()
    {
        /*chech whether queue is empty or not */

        if(front == rear)
        {
            System.out.println("Is empty");
            return;
        }
 

            for(int i = front; i<rear; i++)
            {
                System.out.printf("%d <-- ",queue[i]);
            }
        return;
    }

    public void queueFront()
    {
        if(front == rear)
        {
            System.out.println("Queue is empty");
        }

        System.out.printf("\n%d is top element\n",queue[front]);
    }
}

public class QueueRunner{
    public static void main(String[] args)
    {
        Queue q  = new Queue(6);
        
        q.Enquque(12);
        q.Enquque(17);
        q.Enquque(16);
        q.Enquque(13);
        q.display();
        q.queueFront();
        q.deQueue();
        q.deQueue();
        q.display();
        
    }
}