import cs1.SimpleURLReader;

import java.util.ArrayList;

public class MySimpleURLReader extends SimpleURLReader {
    //variables
    String url;
    String name;

    //constructor
    public MySimpleURLReader(String url)
    {
        super(url);
        this.url = url;

    }

     //accessor methods
    public String getURL()
    {
    return this.url;
    }

    /**
     * a method to get the file name from the URL
     * @return name of the file
     */
    public String getName() {
        for (int i = url.length() - 1; i > 0; i--) {
            if (url.charAt(i) == '/')
            {
                this.name = url.substring(url.charAt(i));
                i = 0;
            }
        }
        return name;
    }

    /**
     * a method to get the number and the name of the CSS  links
     * @return cssFilesArray names of the CSS files
     */
    public String[] getNumberOfCSSLinks()
    {
        ArrayList<String> cssFiles = new ArrayList<String>();
        String[] cssFilesArray;
        String content = this.getPageContents(); //get the unfiltered content
        while(content.contains(".css"))
        {
                for(int j = content.indexOf(".css") ; j > 0 ; j--)
                {
                    if(content.charAt(j) == '/')
                    {
                        cssFiles.add(content.substring(j+1,content.indexOf(".css")+ 4));
                        content = content.substring(content.indexOf(".css")+ 4);
                        j = 0;
                    }
                }

        }
        cssFilesArray = new String[cssFiles.size()];
        for(int i = 0 ; i < cssFiles.size() ; i++)
        {
            cssFilesArray[i] = cssFiles.get(i);
        }
        return cssFilesArray;
    }
}
