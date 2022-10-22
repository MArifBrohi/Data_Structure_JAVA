import java.io.*;
import java.lang.*;
import java.util.*;

class AddElementAtPositionInArray{
    public static int[] insert(int arr[] , int size , int val, int position)
    {
        int i;
        int newArray[] = new int[size+1];

        for(i = 0; i<size+1; i++){
            if(i<position-1){
                newArray[i] = arr[i];
            }
            else if(i == position-1)
            {
                newArray[i] = val;

            }
            else{
                newArray[i] = arr[i-1];
            }
           
        }
        return newArray;
    }
    public static void main(String[] args){

        int size = 10;
        int arr[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(Arrays.toString(arr));
      // initialize val to be inserted
        int val = 50;
      // define position where to be inserted
        int position  = 5;

        arr = insert(arr, size, val, position);
        System.out.println("inserting val "+val+" at postion "+position+"\n"+ Arrays.toString(arr));
    }
}
