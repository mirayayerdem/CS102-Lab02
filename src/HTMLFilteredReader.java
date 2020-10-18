/**
 * a class that filters the contents of websites and get their unfiltered contents
 * @author Miray Ayerdem
 * @version 18/10/2020
 */
public class HTMLFilteredReader extends MySimpleURLReader{
    //instances
    private String unfilteredText;
    //constructor
    public HTMLFilteredReader(String url)
    {
        super(url);  //summoning the parent class' constructor
        unfilteredText = super.getPageContents();
    }

    /**
     * get the string of filtered contents of websites
     * @return unfilteredText a string filtered by the method
     */
   @Override
    public String getPageContents()
   {
        while(unfilteredText.contains("<"))
        {
            int start;
            int end;
            start = unfilteredText.indexOf("<");
            end =unfilteredText.indexOf(">");
            unfilteredText = unfilteredText.substring(0, start) + unfilteredText.substring(end + 1);

        }
        return unfilteredText;
    }

    /**
     *make content of websites accessible by super class
     * @return unfilteredText from super class
     */
    public String getUnfilteredPageContents()
    {
        return this.unfilteredText;
    }

}
