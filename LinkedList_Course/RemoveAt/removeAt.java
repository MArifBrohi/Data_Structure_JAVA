import java.util.Scanner;
class RemoveAtList{
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;

        }

    }
    public static void removeFirst(Node head){
      
        if(head == null){
            return;
        }
        head = head.next;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void RemoveAt(Node head,  int index){

        if(index == 0){
            removeFirst(head);
            
            return;
        }
      
        
        Node temp = head;
        for(int i =1; i<=index-1; i++){
            temp = temp.next;
        }
        Node temp1 = temp.next.next;
        temp.next = temp1;

        Node temp2 = head;


        while(temp2 != null){
            System.out.print(temp2.data+" ");
            temp2 = temp2.next;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node head = n1;
        System.out.println("Enter index to delete: ");
        int index = sc.nextInt();
        RemoveAt(head, index);
      
      
        

    }
}
