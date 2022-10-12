import java.io.FileWriter;

class WritingInFile{
    public static void main(String[] args)
    {
        try{
            FileWriter writeFile = new FileWriter("C:\\Users\\FAB LAB USER\\Desktop\\FILING IO\\File1.txt");
            writeFile.write("Sukkur IBA university: Where high level education is provided: ");
            writeFile.close();
            System.out.println("successfully written in file");
        }
        catch(Exception e)
        {
            System.out.println("An error occurred: ");
            
        }
    }
}