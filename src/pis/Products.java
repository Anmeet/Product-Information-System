/**
 /*SID: 12080721
Name:AMit Bhandari
THis is the main method of the application that implements all the classes SingleMaltPresenter,SingleMlatQueries,SingleMaltView,
 and metod starts the application and connects to the database if the connection is not established then application 
exits*/
 
package pis;

import java.sql.SQLException;
import java.util.Observable;
import pis.controller.SingleMaltController;
import pis.model.IModel;
import pis.model.SingleMaltModel;
import pis.model.SingleMaltQueries;
import pis.view.SingleMaltView;

/**
 * @author amit bhandari
 */
//main method of application
public class Products {
    
//method starts application and if connection cannot be established then program exits
  
    public static void main(String[] args) {
        try {
            SingleMaltQueries singlemaltQueries = new SingleMaltQueries();
            SingleMaltModel singlemaltModel = new SingleMaltModel(singlemaltQueries);
            IModel model = new SingleMaltModel(singlemaltQueries);
            SingleMaltController singlemaltController = new SingleMaltController(model);

            SingleMaltView singlemaltView = new SingleMaltView(singlemaltModel, singlemaltController); 
            ((SingleMaltModel) model).addObserver(singlemaltView); 
            singlemaltView.setVisible(true);//GuI is made visible to user

        } catch (SQLException e) {
            System.out.println("Cannot connect to database" + e.getMessage());
        }

    }
}
