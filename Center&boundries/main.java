class NLArray_02{

    public static void extractBoundaries(int[][] arr, int row , int col)
    {
        for(int i =0; i<row; i++)
        {
            for(int j =0; j<col; j++){
           
            if(i==0||j==0)
            {
                System.out.print("*");
            }
            else if(i==row-1||j==col-1)
            {
                System.out.print("*");
            }
          
            else {
               
                System.out.print(" ");
            }
           
            }
            System.out.println();
        }
    }

    public static void cropCenterPart(int[][] arr, int row , int col)
    {
        for(int i =0; i<row; i++)
        {
            for(int j =0; j<col; j++){
           
            if(i==0||j==0)
            {
                System.out.print(" ");
            }
            else if(i==row-1||j==col-1)
            {
                System.out.print(" ");
            }
          
            else {
               
                System.out.print("*");
            }
           
            }
            System.out.println();
        }
    }
  


    public static void main(String[] args)
    {
        int row = 5; int col = 5;
        int[][] arr = new int[5][5];
        System.out.println("Orignal Array: ");
        for(int i=0; i<row; i++)
        {
            for(int j =0; j<col; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("printing 1st, last row and 1st, last col");

        extractBoundaries(arr, row , col);

        System.out.println("printing all box except 1st row,1st col and last row, last col");
        
        cropCenterPart(arr, row , col);

    }
}
