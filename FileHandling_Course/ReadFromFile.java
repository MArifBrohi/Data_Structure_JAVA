import java.io.File;
import java.util.Scanner;

public class ReadFromFile{
    public static void main(String[] args)
    {
        try {
            File ob = new File("C:\\Users\\FAB LAB USER\\Desktop\\FILING IO\\File1.txt");
            Scanner myReader = new Scanner(ob);
            while(myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            } 
            myReader.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error is occured: ");
            e.printStackTrace();
        }
    }
}