class DLL_01{
    Node head;
    class Node{
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
         
        }
    }
    public void push(int data) {
        Node new_Node = new Node(data);

      

        new_Node.next = head;
        new_Node.previous = null;

        if(head!=null){
            head.previous = new_Node;
        }
        head = new_Node;
    }
    public void printlist(Node node)
	{
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
        System.out.println();
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.previous;
		}

    }





    public static void main(String[] args)
    {
        DLL_01 list = new DLL_01();
        list.push(12);
        list.push(45);
        list.push(67);     
      list.push(15);
       
        list.printlist(list.head);
    }
}
