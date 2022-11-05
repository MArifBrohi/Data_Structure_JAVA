                                                          
                                                      /* THIS CODE IS BROUGHT TO YOU BY MUHAMMMAD ARIF BROHI: */
                                                      
                                                                  /* TALK IS CHEAP, SHOW ME CODE */

class Queue_01{
    public int arr[];
    public int size;
    public int capacity;
    public int rear;
    public int front;

    Queue_01(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        arr = new int[this.capacity];
        this.rear = capacity-1;
    }

    public boolean isFull(Queue_01 q) {
        return (size == capacity);
    }

    public boolean isEmpty(Queue_01 q) {
        return (this.size == 0);
    }

    public void enQueue(int item) {
        if(isFull(this)) {
            System.out.println("No more items be added: ");
            return;
        }else {
            this.rear = (this.rear+1) % this.capacity;
            arr[this.rear] = item;
            this.size = size+1;
            System.out.println("Item is added: "+item);

        }
    }

    public void deQueue() {
        if(isEmpty(this)) {
            System.out.println("No more items be dequeued: ");
        }else {
            int item = arr[this.front];
            this.front = (this.front+1) % this.capacity;
            this.size = this.size-1;
            System.out.println("Item is removed: "+item);
        }
    }

    int frontElement() {
        return arr[this.front];
    }


    public static void main(String[] args) {
        Queue_01 q = new Queue_01(5);
        q.enQueue(12);
        q.enQueue(13);
        q.enQueue(14);
        q.enQueue(15);
        
        q.deQueue();
        q.enQueue(16);
        q.enQueue(17);
        System.out.println("top item is: "+q.frontElement());

    }
}
