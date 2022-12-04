class BinaryMax{
    private int arr[];
    private int size;
  

    BinaryMax(int MAX){
        arr = new int[MAX];
        size = 0;
    }

    // get access to parent
    public int parent(int size){
            return (size-1)/2;
    }

    // get access to leftChild
    public int leftChild(int size){
        return (size*2 + 1);
    }

    // get access to rightChild
    public int rightChild(int size){
        return (size*2 + 2 );
    }

    // insertion of elements
    public void putElements(int keys){
        if(size <= arr.length){
            arr[size] = keys;
            siftUp(size);
            size++;
        }else{
            System.out.println("Index out of bound:");
        }
    }
    
    // sift up, if any element is max than its parent
    public void siftUp(int ind){
        while(ind > 0 && arr[ind] > arr[parent(ind)])
        {
            int temp = arr[ind];
            arr[ind] = arr[parent(ind)];
            arr[parent(ind)] = temp;
            ind = parent(ind);

        }
    }

    // Max value, which will always be root
    public int maxValue(){
        return arr[0];
    }

    // extract max element
    public int extractMax(){
        int max = arr[0];
        arr[0] = arr[--size];
       
        siftDown(0);
        return max;
    }

    // remove specific element
    public void remove(int i){
		arr[i]=Integer.MAX_VALUE;
		siftUp(i);
		extractMax();
    }

    // change priOrity at specific index
    public void changePriority(int i,int key){
		int oldkey=arr[i];
		arr[i]=key;
		if(key>oldkey)
			siftUp(i);
		else
			siftDown(i);

	}

    // siftDown
    public void siftDown(int i){
        int maxIndex = i;
        int l = leftChild(i);
        if(l < size && arr[l] > arr[maxIndex])
        {
            maxIndex = l;
        }
        int r = rightChild(i);
        if(r < size && arr[r] > arr[l]){
            maxIndex = r;
        }
        if(i != maxIndex){
            int temp  = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            siftDown(maxIndex);

        }

    }

    // printing elements 
    public void preOrder(int ind){
        if(ind < size){
            System.out.print(arr[ind]+" ");
            preOrder(leftChild(ind));
            preOrder(rightChild(ind));
        }
    }


    public static void main(String[] args){
        BinaryMax bi = new BinaryMax(5);
        bi.putElements(6);
        bi.putElements(5);
        bi.putElements(8);
        bi.putElements(9);
        bi.putElements(45);
        System.out.println("\nElements: ");
        bi.preOrder(0);
        
        System.out.println("\nMax Value: "+bi.maxValue());
        System.out.println("\nExtract Max: "+bi.extractMax()+"\n");
        System.out.println("\nElements: ");
        bi.preOrder(0);
        // System.out.println("\nafter removing from index 1 ");
        // bi.remove(1);
        // bi.preOrder(0);
        System.out.println("\nchanging priority at 1 index: ");
        bi.changePriority(1, 45);
        bi.preOrder(0);
        

    
    }
}
