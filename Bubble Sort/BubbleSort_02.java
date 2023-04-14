import java.util.Arrays;
class BubbleSort{

    public int[] sort(int[] arr){
        for(var i = 0 ; i<arr.length-1; i++){
            for(var j = i+1 ; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    swaping(arr, i , j);
                }
            }
        }
        return arr;
    }

    private void swaping(int []arr,int index1 , int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }
    public static void main(String[] args){
        int[] numbers = {3,2,6,8,9,1};

        var sorter = new BubbleSort();

        int arr[]=sorter.sort(numbers);

        for(int i =0 ;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    //   System.out.println(Arrays.toString(numbers));

       
    }
}
