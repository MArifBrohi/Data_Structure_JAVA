public class Main{
    public static void main(String[] args)
    {
        String str = "Muha@mmad# 346Arif";
     
       for(int i =0; i<=str.length()-1; i++)
       {
           if(str.charAt(i)>='a'||str.charAt(i)>='A'||str.charAt(i)>='z'||str.charAt(i)>='Z'){
                System.out.print(str.charAt(i));
               
           }
           else if(str.charAt(i)==' ')
                {
                    System.out.print(" ");
                }
           
       }
        
    }
}
