import java.util.Scanner;
class Queue{
    private static int rear,  front , capacity;
    
    static int queue[];
    
    Queue(int size)
    {
        this.capacity = size;
        queue = new int[size];
        rear = front = 0;
    }
    
    public void Enqueue(int data)
    {
        if(capacity == rear){
            System.out.println("Queue is full: ");
        }else{
            queue[rear] = data;
       //     System.out.printf("%d <- " ,data);
        }
        rear++;
    }
    public void deQueue()
    {
        if(rear == front){
            System.out.println("Queue is empty: ");
        }else{
            for(int i = front; i<(rear-1); i++){
                queue[i] = queue[i+1];
               
            }
            rear--;
        }
    }
    public void display()
    {
        if(rear == front){
            System.out.println("Queue is empty: ");
        }else{
            for(int i = front; i<rear; i++){
                System.out.print(queue[i]+" <- ");
            }
        }
    }
    public void topElement()
    {
        if(rear == front)
        {
            System.out.println("Queue is empty: ");
        }
        else{
            System.out.println("\nfront element is "+queue[front]);
        }
    }
    public boolean isEmpty()
    {
        if(rear == front)
        {
            
            return true;
        }
        else{
            return false;
        }
    }
}
public class Queue_Ex_01
{
    public static void main(String[] args){
        Queue q = new Queue(5);
         Scanner sc = new Scanner(System.in);
        int choice;
        do{
        
        System.out.println("================================");
        System.out.println("Enter 1 for inserting value: ");
        System.out.println("Enter 2 for deletion: ");
        System.out.println("Enter 3 display queue: ");
        System.out.println("Enter 4 for topElement: ");
        System.out.println("Enter 5 for end program: ");
        System.out.println("================================");
        
       
        choice = sc.nextInt();
        
       

        
        
      
        switch(choice)
        {
            //   Scanner sc = new Scanner(System.in);
            case 1:
                System.out.println("Enter value: ");
                int val = sc.nextInt();
                q.Enqueue(val);
                break;
            case 2:
            System.out.print("\n");
                q.deQueue();
                break;
            case 3:
               
                q.display();
                System.out.print("\n");
                break;
             case 4:
             System.out.print("\n");
                 q.topElement();
                 break;



        }
        }while(choice!=5);
   
        
    }
    
  
}
