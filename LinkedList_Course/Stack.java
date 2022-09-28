import java.util.*;

public class Stack{

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

	public Stack()
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
                System.out.println("list is empty");
                head = null;
                return;
            }
        
            if(head.next == null){
                head = null;
                return;
            }
            
                // traverse to the second last element of the list

                Node secondLast = head;
                Node lastNode = head.next;
                while(lastNode.next != null)
                {
                    lastNode = lastNode.next;
                    secondLast = secondLast.next;  
                    
                }
                secondLast.next = null;
                
            
        }

    // public void pop()
    // {
    //     if(head != null)
    //     {
    //         Node temp = this.head;
    //         this.head = this.head.next;
    //         temp = null;
            
    //     }

    // }
    public void display(){
        if(head==null)
        {
            System.out.println("Empty list: ");
        }
        
             Node cur = head;
             
             while(cur!=null)
             {
                 System.out.println(cur.data+" is added");
                 
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
           Stack list = new Stack();
           list.push(1);
           list.push(2);
           list.push(3);
           list.display();
           System.out.println("peek node is "+list.peek());
           System.out.println("isEmpty "+list.isEmpty());
           System.out.println("size is: "+list.size());
           list.pop();
           list.display();
           list.pop();
           list.pop();
           System.out.println("isEmpty "+list.isEmpty());
           list.display();
          
          
      
         
       }
}