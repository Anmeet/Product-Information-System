
/**
 * Name: Amit Bhandari
 * Student Id- 12080721
   Functionality:This class provides all the information about the single malt.it consists all the getters and
  setter methods of singlemalt.
 */

package pis.model;

public class SingleMalt {
    private String distillery;
    private int age;
    private String region;
    private int price;
    
    //parametrized constructor
    public SingleMalt(String distillery, int age, String region, int price) {
        this.distillery = distillery;
        this.age = age;
        this.region = region;
        this.price = price;
    }
//getters and setters method for singlemalt
    public String getDistillery() {
        return distillery;
    }

    public void setDistillery(String distillery) {
        this.distillery = distillery;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
//method convert the integer,string value into string format
    @Override
    public String toString() {
        return '<' + distillery + ", " + age + ", " + region + ", " + price + '>';
  
    }
               
}
