import java.util.ArrayList;
/**
 * a class that finds the count and the location of the word in the text
 * @author Miray Ayerdem
 * @version 18/10/2020
 */

public class WordSearch extends HTMLFilteredReader{
    //Constructor
    public WordSearch (String url)
    {
        super(url);
    }

    /**
     * a method to check the word's count and the location if the word is in it
     * @param word the desired word
     */
    public void checkWord(String word)
    {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        String content;
        content = super.getPageContents();
        int count = 0;
        int index = 0;
        int counter = 0;
        for(int i = 0 ; i < content.length() ; i++) {
            if(content.charAt(i) == '&')
            {
                counter = i;
            }
            if(content.charAt(i) == ';' && counter != 0)
            {
                content = content.substring(0,counter) + content.substring(i+1);
                counter = 0;
            }
        }
        while(content.contains(word)) //if the text contains the word add its indexes to the arraylist
        {
            count++;
            indexes.add(content.indexOf(word));
            content = content.substring(0, content.indexOf(word)) + content.substring(content.indexOf(word)+ word.length());
        }
        content = super.getPageContents(); //the original content
        System.out.println("This content contains " + word + " " +count + " times." );
        if(indexes.size() == 0)
            System.out.println("There is no " + word + " in the text!");
        else {
            for (int i = 0; i < indexes.size(); i++) {
                System.out.println("The location of the word is between" + " " + indexes.get(i) + " and " + (indexes.get(i) + word.length() - 1));
            }
        }

    }
}
