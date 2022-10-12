     /*JAVA FILE METHODS
                                                                                
                1. canRead()  test whether file is readable
                2. canWrite() test whether file is writabale
                3. createNewFile() creates new File
                4. Delete()   delete that file 
                5. Exist()  cheaks whether file exists or not
                6. getName()  return name of file
                7. getAbsolutePath()   return absolute pathname
                8. Length()  Returns the size of the file
                9. List()   return the array of the file
                10. Mkdir()    create a directory
       */

import java.io.File;
import java.io.IOException;


public class CreateFile{
    public static void main(String[] args)
    {
        try {
            File ob = new File("C:\\Users\\FAB LAB USER\\Desktop\\FILING IO\\File1.txt");
            if(ob.createNewFile())
            {
                System.out.println("File is created: ");
                System.out.println("File Name: "+ob.getName());
            }
            else                                                           
            {
                System.out.println("File already exists: ");
            }
        } catch (Exception e) {
            // TODO: handle exception

            System.out.println("An error Occured: ");
        
        }
    }
}
