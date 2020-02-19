
/**
 * Name: Amit Bhandari
 * Student Id- 12080721
 * Functionality:This method implements all the interface of Imodel by acting as an observable.Obserbvable updates all the 
 * data as per the specification.
*/
package pis.model;

import java.util.List;
import java.util.Observable;

public class SingleMaltModel extends Observable implements IModel {

    SingleMaltQueries singlemaltQueries;
    ViewState viewState;
    List<SingleMalt> singlemaltList = null;
    int index;

    public SingleMaltModel(SingleMaltQueries queries) {
        this.singlemaltQueries = queries;
    }
    
//method to update the price of single malt
    @Override
    public void changePriceForMalt(String distillery, int age, int price) {
        int resultUpdate = singlemaltQueries.changePriceForMalt(distillery, age, price);
        String resultStatus;
        resultStatus = resultUpdate == 0? "Couldnot update the price of malt" :"Records Update:"+resultUpdate;
        setChanged();
        notifyObservers(resultStatus);
    }

    //method that clear all the input and output fields of text field and text area
    @Override
    public void clear() {
        setChanged();
        notifyObservers("");
    }

    //method closes connection with database
    @Override
    public void close() {
        singlemaltQueries.close();
    }
  
    //method display all the records of single malt
    @Override
    public void setToAllMalts() {
        singlemaltList = singlemaltQueries.getAllMalts();
        if (!singlemaltList.isEmpty()) {
            index = 0;
            SingleMalt singleMalt = singlemaltList.get(index);
            String messageDisplay = String.format("Record %d of %d.", index + 1, singlemaltList.size());
            viewState = new ViewState(singleMalt, messageDisplay);
            setChanged();
            notifyObservers(viewState);
        } else {
            setChanged();
            notifyObservers("No records found");
        }
    }
    
    //method displays all the single malts from the specified region
    @Override
    public void setToMaltsFromRegion(String region) {
        singlemaltList = singlemaltQueries.getMaltsFromRegion(region);
        if (!singlemaltList.isEmpty()) {
            index = 0;
            SingleMalt singleMalt = singlemaltList.get(index);
            String message = String.format("Record %d of %d.", index + 1, singlemaltList.size());
            viewState = new ViewState(singleMalt, message);
            setChanged();
            notifyObservers(viewState);
        } else {
            setChanged();
            notifyObservers("No records found");
        }
    }

   //method diplays all the single malts within the specified age range
    @Override
    public void setTofMaltsWithinAgeRange(int lowerboundAge, int upperboundAge) {
        singlemaltList = singlemaltQueries.getMaltsWithinAgeRange(lowerboundAge, upperboundAge);
        if (!singlemaltList.isEmpty()) {
            index = 0;
            SingleMalt singleMalt = singlemaltList.get(index);
            String message = String.format("Record %d of %d.", index + 1, singlemaltList.size());
            viewState = new ViewState(singleMalt, message);
            setChanged();
            notifyObservers(viewState);
        } else {
            setChanged();
            notifyObservers("No records found");
        }
    }
 
    //method displays the next record of singlemaltlist.
    @Override
    public void setNext() {
        if (!singlemaltList.isEmpty()) {
            if (singlemaltList.size() - 1 == index) {
                index = 0;
            } else {
                index = index + 1;
            }
            SingleMalt singleMalt = singlemaltList.get(index);
            String message = String.format("Record %d of %d.", index + 1, singlemaltList.size());
            viewState = new ViewState(singleMalt, message);
            setChanged();
            notifyObservers(viewState);
        } else {
            setChanged();
            notifyObservers("No Records found.");
        }
    }

    //method that display previous record of the singlemaltList
    @Override
    public void setPrevious() {
        if (!singlemaltList.isEmpty()) {
            if (index == 0) {
                index = singlemaltList.size()-1;
            } else {
                index = index - 1;
            }
            SingleMalt singleMalt = singlemaltList.get(index);
            String message = String.format("Record %d of %d.", index + 1, singlemaltList.size());
            viewState = new ViewState(singleMalt, message);
            setChanged();
            notifyObservers(viewState);
        } else {
            setChanged();
            notifyObservers("No Records found.");
        }
    }

}
