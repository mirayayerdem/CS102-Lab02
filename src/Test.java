import cs1.SimpleURLReader;

public class Main {
    public static void main(String[] args)
    {
       //SimpleURLReader page = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt");
        SimpleURLReader page = new SimpleURLReader("https://scrapethissite.com/pages/simple");
        System.out.println(page);

        int numberOfLine;
        String content;
        content = page.getPageContents();
        numberOfLine = page.getLineCount();
        System.out.println(content);
        System.out.println("The number of lines is: " + numberOfLine);

    }
}
