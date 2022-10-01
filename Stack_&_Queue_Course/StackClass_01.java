/*       Name:    Muhammad Arif Brohi
 *       Class:   BS_CS(A.I & ROBOTICS)
 *       SECTION:     B
 *       CMS :        193-21-0007
 */


import java.util.*;
class Stack{
    int top;
    final static int MAX = 2;
    int stack[] = new int[MAX];

    Stack()
    {
        top = -1;
    }

    // check whether Stack is empty or not

    boolean isEmpty()
    {
        if(top == -1)
        {
            return true;
        }
        else{
            return false;
        }
    }

    // function to return size

    int size()
    {
        return top+1;
    }

    // adding elements in Stack

   public void push(int x)
    {
        if(top == (MAX-1))
        {
            System.out.println("Stack reached at limit");
        }
        else{
            stack[++top] = x;

            System.out.println(x+" is added");
        }
       
    }

         public int peek()
        {
            if(top<0)
            {
                System.out.println("Empty");
                return 0;
            }
            else{
                return stack[top];
            }
        }

    void pop()
    {
        if(top<0)
        {
            System.out.println("Stack is empty");
        }
        else{
            int x = stack[top--];

            System.out.println(x+" is removed from stack");
        }
    }




}

class StackClass_01{
    public static void main(String [] args)
    {
        Stack stack = new Stack();

       
         stack.push(12);
         stack.push(56);
         stack.push(78);

        stack.pop();
      
        System.out.println("Stack size "+stack.size());
        System.out.println("Top element: "+stack.peek());
        stack.pop();
        if(stack.isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is not empty");
        }
        System.out.println("Top element: "+stack.peek());
    }
}