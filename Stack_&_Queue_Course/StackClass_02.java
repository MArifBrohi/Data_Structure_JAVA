import java.util.*;

public class StackClass_02{

    public int size = 1;
    class Node{
        public int data;
        public Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    private Node head;

	public StackClass_02()
	{
		head = null;
	}
  
 
  
    
    public void push(int data)
    {
        Node newNode = new Node(data);
        
        if(head == null)
        {
            head = newNode;
            return;
        }
            
            Node curNode = head;
            while(curNode.next != null)
            {
                curNode = curNode.next;
                
            }
            curNode.next = newNode;
            size++;
            
    }

    public void pop()
    {
        if(head == null)
        {
            head = null;
            return;
        }

        if(head.next == null)
        {
            System.out.println("removing "+head.data);
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next!=null)
        {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        System.out.println("removing "+lastNode.data);
        secondLast.next = null;
    }


    public void display(){
        if(head==null)
        {
            System.out.println("Empty list: ");
        }
        
             Node cur = head;
             
             while(cur!=null)
             {
                 System.out.println("inserting "+cur.data);
                 
                 cur = cur.next;
             }
             
       }
       public int peek(){
            Node peekNode = head;
            
            while(peekNode.next!=null)
            {
                peekNode = peekNode.next;
            }
            return peekNode.data;
            
       }

       public boolean isEmpty()
       {
            if(head == null)
            {
                return true;
            }
            else{
                return false;
            }
       }

       public int size()
       {
        return size;
       }
       
       public static void main(String[] args)
       {
           StackClass_02 stack = new StackClass_02();
           stack.push(1);
           stack.push(2);
           stack.push(3);
           stack.display();
           System.out.println("top element is " +stack.peek());
           stack.pop();
           stack.pop();
           stack.pop();
           System.out.println("isEmpty "+stack.isEmpty());
          
          
          
      
         
       }
}