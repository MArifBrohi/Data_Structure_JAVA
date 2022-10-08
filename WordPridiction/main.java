import java.util.Collections;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;


class WordPrediction{
    public static void main(String[] args)
    {
        String input = "Sun and Moon U";
        String[] phraseToList = generatePridictedText(input,false);
        for(int i =0; i<phraseToList.length; i++)
        {
            System.out.println(phraseToList[i]);
        }
    }


    public static String[] generatePridictedText(String userInput, boolean caseSensitive)
    {
        String[] listofAllPhrase = getWords("data.txt");

        return genratePhraseList(userInput, listofAllPhrase, caseSensitive);
    }

    public static String[] genratePhraseList(String userInput, String[] listOfPhrase , boolean caseSensitive)
    {
            ArrayList<String> phrase = new ArrayList();
            for(int  i =0; i<listOfPhrase.length; i++)
            {
                if(caseSensitive)
                {
                    if(listOfPhrase[i].startsWith(userInput))
                    {
                        phrase.add(listOfPhrase[i]);
                    }
                }
                else{
                    if(listOfPhrase[i].toUpperCase().startsWith(userInput.toUpperCase()))
                    {
                        phrase.add(listOfPhrase[i]);
                    }
                }
            }
            return phrase.toArray(new String[0]);
    }
    public static String[] getWords(String filepath)
    {
        ArrayList<String> phrase = new ArrayList();

        try{
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while((currentLine = bufferedReader.readLine())!= null)
            {
                phrase.add(currentLine);
            }
            bufferedReader.close();
            fileReader.close();

            Collections.sort(phrase);
        }
        catch(Exception e){
            phrase.add(e.toString());          
        }

        return phrase.toArray(new String[0]);
    }
}
