/**
 * Name: Amit Bhandari
 * Student Id- 12080721
 * functionality: This class has the various method that read and operate data on singlemalts such as next ,previous etc
 */
package pis.model;

public interface IModel {
    
   //method to update price for malt
    public void changePriceForMalt(String distillery, int age, int price);
    
   //method that clears the text field and text area
    public void clear();
    
    //method that closes the conncetion with database
    public void close();
    
    //method that display all singlemalts
    public void setToAllMalts();
    
  //method to display malts from specific region
    public void setToMaltsFromRegion(String region);
    
  //method to display singlemalts within specified age range
    public void setTofMaltsWithinAgeRange(int age1, int age2);
    
    //method that display next record
    public void setNext();
    
  //method that display previous record
    public void setPrevious();
    
}
