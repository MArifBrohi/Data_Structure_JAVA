class Queue{
    static int size;
    static int arr[] = new int[5] ;
   
    int rear;
    
    public void enQueue(int data)
    {
        arr[rear] = data;
        
        size = size+1;
        rear = rear+1;
    }
    public void show()
    {
           System.out.println("Elements ");
        for(int i = 0; i<size; i++)
        {
         
            System.out.print(arr[i]+" ");
        }
    }
}
public class Runner{
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enQueue(34);
        q.enQueue(5);
        q.enQueue(56);
        q.show();
    }
}
