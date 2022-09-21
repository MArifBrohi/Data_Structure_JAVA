import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
class NLArray_01{
    public static void main(String[] args) throws IOException
    {
       
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Filing.txt"));
           
            writer.write("Muh@am$mad %arif!");
            writer.write("\nIBA Su@kkur Unive@rsity: ");
           
            writer.close();
        } catch (IOException e) {
      
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Filing.txt"));
            String line;
            while((line = reader.readLine())!=null)
            {   
                int i = 0;
                char[] charArray = line.toCharArray();
                if(charArray(i)>='a'||charArray(i)>='A'||charArray(i)<='z'||charArray(i)<='Z')
                {
                    
                    System.out.println(charArray[i]);
                }
                i++;
             
            }

            reader.close();

        } 
        catch (FileNotFoundException e) {
  
            e.printStackTrace();
        }
      /*  try {
            BufferedReader reader = new BufferedReader(new FileReader("Filing.txt"));
            String line;
            
                for(int i =0; i<100; i++ ) 
                {
                    line = reader.readLine(); 
                    char[] charArray = line.toCharArray();
                    if(charArray(i)>='a'||charArray(i)>='A'||charArray(i)<='z'||charArray(i)<='Z')
                    {
                        
                        System.out.println(charArray[i]);
                    }
                   
                }
                reader.close();
        }       
    
        catch (FileNotFoundException e) {
  
            e.printStackTrace();
        }*/
        
    }
}
