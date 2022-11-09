import java.util.Scanner;
class TransposeOfMatrix{

    public static void transpose(int arr[][]){
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("Transpose of Matrix: ");
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

        TransposeOfMatrix.transpose(arr);
    }
}