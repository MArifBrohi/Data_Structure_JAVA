class PriorityQueue{
    private int MAX;
    private int[] arr;
    private int nItems;

    PriorityQueue(){
        MAX = 10;
        arr = new int[MAX];
        nItems = 0;
    }

    public void insert(int val) {
        int i;
        try {
            if(isFull() == true){
                System.out.println("No Values can be inserted: StackOverflow");
                
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        
        if(nItems == 0){
            arr[0] = val;
            nItems++;
            return;
        }
        for(i = nItems-1; i>=0; i--)
        {
            if(val > arr[i]){
                arr[i+1] = arr[i];
            }else{
                break;
            }
        }
        arr[i+1] = val;
        nItems++;
    }
    public void printPriorityQueue(){
        for(int i = 0; i<nItems; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public int remove(){
        return arr[--nItems];
    }
    public boolean isFull(){
        if(nItems == MAX){
            return true;
        }
        else{
            return false;
        }
    }
    public int getMax(){
        int temp = arr[nItems-1];
        return temp;
    }
    public static void main(String[] args){
        PriorityQueue ob = new PriorityQueue();
        ob.insert(7);
        ob.insert(5);
        ob.insert(8);
        ob.insert(9);
        ob.insert(2);
        ob.insert(1);
       
        ob.printPriorityQueue();
        System.out.println();
        System.out.println("highest priority: "+ob.getMax());

        System.out.println("Removing hgihest priority person: ");
        ob.remove();
        ob.printPriorityQueue();
        System.out.println();
        System.out.println("highest priority: "+ob.getMax());
        
       
    }
    
}
