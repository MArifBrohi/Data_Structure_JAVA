import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
class NLArray_01{
    public static void main(String[] args)
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
            try {
                for(int i =0; i<(reader.readLine().length())-1; i++ ) 
                {
                    line = reader.readLine(); 
                    if(line.charAt(i)>='a'||line.charAt(i)>='A'||line.charAt(i)>='z'||line.charAt(i)>='Z')
                    {
                        System.out.println(line);
                    }
                }
            
                 reader.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
           

        } 
        catch (FileNotFoundException e) {
  
            e.printStackTrace();
        }
        
    }
}
