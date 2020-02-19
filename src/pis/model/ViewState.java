
/**
 * Name: Amit Bhandari
 * Student Id- 12080721
 * functionality:The class stores all the record of the single malt and display the message to the user.
 * 
 */
package pis.model;

public class ViewState {

    private final SingleMalt singleMalt;
    private final String messageDisplay;
    
    public ViewState(SingleMalt singlemalt, String message) {
        this.singleMalt = singlemalt;
        this.messageDisplay = message;
    }

    //method returns the record of singlemalt
    public SingleMalt getSingleMalt() {
        return singleMalt;
    }
//method returns the messageDisplay which is displayed to the user.
    public String getMessageDisplay() {
        return messageDisplay;
    }
    
}
