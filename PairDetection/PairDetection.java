class PairDetection{

    public static boolean pairDetect(int arr[] , int z , int size)
    {
        for(int i = 0; i<size; i++)
        {
            for(int j =0; j<size; j++)
            {
                if(i!=j && arr[i]+arr[j] == z)
                    return true;
               
                    // it will return true bcz where 4+(-4) == z
                
            }
       
        }
        return false;
       

    }
    public static void main(String[] args)
    {
        int z = 0;
        int size;
        int arr[] = {1,3,4,2,-4,5};
        size = arr.length;
        if(pairDetect(arr, z, size)==true)
            System.out.println("True");
        else
            System.out.println("false");
      

    }
}
