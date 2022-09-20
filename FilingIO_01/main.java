import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

class FileIO{
    public static void main(String[] args) throws IOException
    {
        String[] names = {"Ali" , "khan", "Baloch"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
           
            writer.write("Muhammad arif");
            writer.write("\nIBA Sukkur University: ");
            for(String name : names){
                writer.write("\n"+name);
            }
            writer.close();
        } catch (IOException e) {
      
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Output.txt"));
            String line;
            while((line = reader.readLine())!=null)
            {
                System.out.print(line+"\n");
            }

            reader.close();

        } 
        catch (FileNotFoundException e) {
  
            e.printStackTrace();
        }
        

    }
}
