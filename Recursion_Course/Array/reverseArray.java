class Driver_rec{

    public static void recursive_cal(int arr[], int i){
       
      
        if(i == 0){
            System.out.print(arr[i]+" ");
            return;
        }
        
        System.out.print(arr[i]+" ");
        
        
        recursive_cal(arr , i-1);
    }
    public static void main(String [] args){
        int arr[] = {10,20,30,40,50,60};
        int i  = arr.length-1;
        recursive_cal(arr, i);


    }
}
