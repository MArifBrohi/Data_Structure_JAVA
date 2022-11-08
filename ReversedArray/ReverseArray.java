import java.util.Scanner;
class ReverseArray{
    public static void main(String[] args) {
        int size;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Size of an Array: ");
        size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter Elements of an Array: ");
        for(int i =0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        int i = 0 , j = size-1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println("Reversed Array: ");
        for(int k = 0; k<arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
    }
}
