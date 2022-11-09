import java.util.Scanner;
class Rotate_2d_arr_ClockWise{
    public static void Rotate(int arr[][], int row, int col){
      
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
      
        for(int i = 0 ; i < arr.length; i++){
            int start = 0;
            int end = col-1;
            while(start<end){
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }
        System.out.println("Rotation of Matrix: ");
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
       
    }
    public static void main(String[] args){
        int row, col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row: ");
        row = sc.nextInt();
        System.out.println("Enter col: ");
        col = sc.nextInt();
        System.out.println("Enter elements for an array: ");
        int arr[][] =  new int[row][col];
        for(int i =0; i<row; i++){
            for(int j =0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Output: ");
        for(int i=0; i<row; i++ ){
            for(int j =0 ; j<col; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        Rotate_2d_arr_ClockWise.Rotate(arr, row , col);
    }
}
