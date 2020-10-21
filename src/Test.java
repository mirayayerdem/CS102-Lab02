import cs1.SimpleURLReader;
/**
 * a class that tests HTMLFilteredReader, MySimpleURLReader and WordSearch classes
 * @author Miray Ayerdem
 * @version 18/10/2020
 */
public class Test {
    public static void main(String[] args)
    {
        int numberOfLine;
        String content;

        SimpleURLReader page = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt");
        //PART A
        content = page.getPageContents();
        numberOfLine = page.getLineCount();
        System.out.println(content);
        System.out.println("The content " + numberOfLine + " lines!");
        //PART B
        MySimpleURLReader page2 = new MySimpleURLReader("https://scrapethissite.com/pages/simple");
        System.out.println("The url of the page: " + page2.getURL());

        //PART C
        System.out.println("CSS Links on the website: ");
        for(int i = 0 ; i < page2.getNumberOfCSSLinks().length ; i++)
        {
            System.out.println( page2.getNumberOfCSSLinks()[i]);
        }
        System.out.println("The number of the CSS Links on the website: " + page2.getNumberOfCSSLinks().length);

        //PART D
        HTMLFilteredReader page3 = new HTMLFilteredReader("https://scrapethissite.com/pages/simple/");
        System.out.println(page3.getPageContents());

        //PART E
        WordSearch page4 = new WordSearch("https://scrapethissite.com/pages/simple/");
        page4.checkWord("Turkey");
        page4.checkWord("Ankara");
        page4.checkWord("St. Johns");






    }
}
