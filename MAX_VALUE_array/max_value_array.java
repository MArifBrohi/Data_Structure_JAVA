import java.util.Scanner;
class MAx_VAlUE_ARRAY{
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        num = sc.nextInt();
        int arr[] = new int[num];
        System.out.println("Enter Values of an array: ");
        for(int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Max value in array: "+max);
    }
}
