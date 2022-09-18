import java.util.Arrays;
class CopyArray_02{
    public static void main(String[] args)
    {
        int[] orignal = {12,23,45,67,89,56,78};
        int[] copy = new int[orignal.length];
        
        //builtn method(arrayyName, start, wheretoCopy, start , end)

        System.arraycopy(orignal, 0, copy, 0, orignal.length);
        System.out.println("Orignal Array: ");

        // Now changing into orignal array will not affect to copy arrray
        orignal[2] = 123;
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
