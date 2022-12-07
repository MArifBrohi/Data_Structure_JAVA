// Java program to construct binary tree from
// given array in level order fashion

public class BinaryMin {
	int[] root;
    int size;

    BinaryMin(int length){
        root=new int[length];
        size=0;
    }

    public int parent(int i){
        // int x=(int)(Math.ceil((i/2f)-1));
        return (i-1)/2;
    }

    public int leftChild(int i){
        return i*2+1;
    }

    public int rightChild(int i){
        return i*2+2;
    }

	public int getMin(){
		return root[0];
	}

    public void insert(int key){
        if(size<root.length){
            root[size]=key;
            siftUp(size);
            size++;
        }
    }

    public void siftUp(int i){
        while(i>0 && root[i]<root[parent(i)]){
            int temp=root[i];
            root[i]=root[parent(i)];
            root[parent(i)]=temp;
			i=parent(i);
        }
    }

	public int extractMin(){
		int result=root[0];
		root[0]=root[--size];
		siftDown(0);
		return result;
	}

	public void siftDown(int i){
		int minIndex=i;
		int l=leftChild(i);
		if(l<size && root[l]<root[minIndex])
			minIndex=l;
		int r=rightChild(i);
		if(r<size && root[r]<root[minIndex])
			minIndex=r;
		if(i!=minIndex){
			int temp=root[i];
			root[i]=root[minIndex];
			root[minIndex]=temp;
			siftDown(minIndex);
		}
	}

	public void remove(int i){
		root[i]=Integer.MIN_VALUE;
		siftUp(i);
		extractMin();
	}

	public void changePriority(int i,int key){
		int oldkey=root[i];
		root[i]=key;
		if(key<oldkey)
			siftUp(i);
		else
			siftDown(i);

	}

	// Function to print tree nodes in InOrder fashion
	public void preOrder(int index)
	{
		if (index<size) {
            System.out.print(root[index] + " ");

			preOrder(leftChild(index));
			
			preOrder(rightChild(index));
		}
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		BinaryMin tree=new BinaryMin(6);
		tree.insert(7);
		tree.insert(14);                 //               1
		tree.insert(21);                 //       6                 3
		tree.insert(3);                  //   14       7       21
		tree.insert(6);
		tree.insert(1);

		tree.preOrder(0);

        tree.changePriority(1, 5);
        System.out.println();
        tree.preOrder(0);


	}
}

