class CopyArray{
    public static void main(String []args)
    {
        int orignal[] = {12,34,546,78,89};
        int copy[] = orignal;
        System.out.println("Orignal Array:");
        orignal[2] = 213; // if you make changes in orignal array, copied array will automatically be changed
        for(int i =0; i<orignal.length; i++)
        {
            System.out.print(orignal[i]+" ");
        }
       
        System.out.println("\nCopied Array:");
        for(int i =0; i<orignal.length; i++)
        {
            System.out.print(copy[i]+" ");
        }

    }
}
