import java.util.Scanner;
class SubArray{
    public static void main(String[] args){
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        size =sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter elements of an array: ");
        for(int i =0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        for(int i =0 ; i<size; i++){
            for(int j = i; j<size; j++){
                for(int k =i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
}
