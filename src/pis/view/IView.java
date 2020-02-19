
/**
 * Name: Amit Bhandari
 * Student Id- 12080721
 * Functionality: This is the interface which declare all the methods used by the singleMaltView to render data to show to user
 * 
 */
package pis.view;

public interface IView {
   
    //method display data to user
    void display(String s);
    
//method enables or disable browsing option i.e. enable and disable next and previous button.
    void browsing(boolean on);
}
