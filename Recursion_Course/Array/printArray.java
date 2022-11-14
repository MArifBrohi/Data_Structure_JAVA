class PrintArray{

    public static void recursive_cal(int arr[] , int i){
        if(i == arr.length){
            return;
        }
        System.out.print(arr[i]+" ");
        recursive_cal(arr, i+1);
    }
    public static void main(String []args){
        int arr[] = {10,20,30,40,50,60};
        int i = 0;

        recursive_cal(arr, i);
    }
}
