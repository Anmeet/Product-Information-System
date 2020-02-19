/**
 * Name: Amit Bhandari
 * Student Id- 12080721
 * Functionality: This class contains all the methods to close the connection,display single malts,display malts within age range and region and 
 * has the functionlaity of next and previous button.It provides necessary data so that database can be accessed.
 * 
 */
package pis.controller;

import pis.model.IModel;
import pis.view.IView;

public class SingleMaltController {

    private IModel iModel;
    private IView view;

    public SingleMaltController(IModel m) {
        this.iModel = m;
    }

    //this method display all singlemalts
  
    public void allMalts() {
        iModel.setToAllMalts();
    }

    //method binds view and presenter class together
    public void bind(IView v) {
        view = v;
    }

    //this method clear the text area and text field from the gui
    public void clear() {
        iModel.clear();
    }
//method to close connection and database
    public void closeConnection() {
        iModel.close();
    }
//method display single malts from the specific region
       public void maltsFromRegion(String region) {
        iModel.setToMaltsFromRegion(region);
    }

   //method display all the single malts with the user specified age range
    public void maltsInAgeRange(String age1, String age2) {
        int lowerAge = Integer.parseInt(age1);
        int upperAge = Integer.parseInt(age2);
        iModel.setTofMaltsWithinAgeRange(lowerAge, upperAge);
    }

    //method that display next single malt when next button is clicked
    public void next() {
        iModel.setNext();
    }

    /**
     * Method that display previous Single Malt when previous button is clicked 
     */
    public void previous() {
        iModel.setPrevious();
    }
   
    //method that update price when distillery age and price are provided as an input
    public void updatePrice(String distillery, String age, String price) {
        int ag = Integer.parseInt(age);
        int pr = Integer.parseInt(price);
        iModel.changePriceForMalt(distillery, ag, pr);
    }
}
