
/**
 * Name: Amit Bhandari
 * Student Id- 12080721
   Functionality:This class implements Iqueries class to handle SQLException.Also it sets the username,password and url of the database and 
 create queries to update price, select all malts, select malts from region,select age from all the malts between age range.
 and closes the connection.
 */

package pis.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleMaltQueries{

  // set the username,password and URL of the database. 
    private static final String URL = "jdbc:derby://localhost:1527/PIS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection = null;
    private PreparedStatement selectAllMalts = null;
    private PreparedStatement selectMaltsFromRegion = null;
    private PreparedStatement selectMaltsWithinAgeRange = null;
    private PreparedStatement updatePriceForMalt = null;

    private List< SingleMalt> results = null;

    ResultSet resultSet;

    public SingleMaltQueries() throws SQLException{
        this.resultSet = null;
        
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //prepared statemetns that select all singlemalts
            selectAllMalts = connection.prepareStatement("SELECT * FROM SINGLEMALTS");
            //prepared statement that select the malts from the specific region
            selectMaltsFromRegion = connection.prepareStatement(
                    "SELECT * FROM SINGLEMALTS WHERE REGION = ?");
            //prepared statement that selects the malts from the specificied age range
            selectMaltsWithinAgeRange = connection.prepareStatement("SELECT * FROM SINGLEMALTS WHERE AGE >= ? AND AGE <= ?");
            //prepared statement for updating the price of malt when given distillery and age of that malt
            updatePriceForMalt = connection.prepareStatement("UPDATE SINGLEMALTS SET PRICE = ? WHERE DISTILLERY = ? AND AGE = ?");
        
    }

  //method that update price of single 
    public int changePriceForMalt(String distillery, int age, int price) {
        int result = 0;
        try {
            updatePriceForMalt.setInt(1, price);
            updatePriceForMalt.setString(2, distillery);
            updatePriceForMalt.setInt(3, age);
            result = updatePriceForMalt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error is " + ex.getMessage());

        } finally {
            closeResultSet(resultSet);
        }
        return result;
    }

  //method extract all single malt record frome the database
    public List<SingleMalt> getAllMalts() {
        results = new ArrayList<>();
        try {//this execute query and return the ResultSet if the entries is matched
       
            resultSet = selectAllMalts.executeQuery();
            while (resultSet.next()) {
                results.add(new SingleMalt(
                        resultSet.getString("distillery"),
                        resultSet.getInt("age"),
                        resultSet.getString("region"),
                        resultSet.getInt("price")
                ));
            }

        }
        catch (SQLException ex) {
            System.out.println("Error is " + ex.getMessage());
        } finally {
            closeResultSet(resultSet);
        }
        return results;
    }

    //method that retrieves the singlemalt records from database with specific region
    public List<SingleMalt> getMaltsFromRegion(String region) {
        results = new ArrayList<>();
        try {
            selectMaltsFromRegion.setString(1, region);
            resultSet = selectMaltsFromRegion.executeQuery();
            while (resultSet.next()) {
                results.add(new SingleMalt(
                        resultSet.getString("Distillery"),
                        resultSet.getInt("Age"),
                        resultSet.getString("Region"),
                        resultSet.getInt("Price")));
            }
        } catch (SQLException ex) {
            System.out.println("Error is " + ex.getMessage());
        } finally {
            closeResultSet(resultSet);
        }
        return results;
    }

    //method retrieve single malt record from the database within the specific age range 
    public List<SingleMalt> getMaltsWithinAgeRange(int age1, int age2) {
        results = new ArrayList<>();
        try {
            selectMaltsWithinAgeRange.setInt(1, age1);
            selectMaltsWithinAgeRange.setInt(2, age2);
            resultSet = selectMaltsWithinAgeRange.executeQuery();
            while (resultSet.next()) {
                results.add(new SingleMalt(
                        resultSet.getString("Distillery"),
                        resultSet.getInt("Age"),
                        resultSet.getString("Region"),
                        resultSet.getInt("Price")));
            }
        } catch (SQLException e) {
            System.out.println("Error is " + e.getMessage());
        } finally {
            closeResultSet(resultSet);
        }
        return results;
    }

    //method closes the connection with database and preparedstatements
    public void close() {
        try {
            connection.close(); //close Connection
            
            //close Prepared Statements
            selectMaltsWithinAgeRange.close();
            selectMaltsFromRegion.close();
            updatePriceForMalt.close();
        } catch (SQLException e) {
            System.out.println("Error is :" + e.getMessage());
        }
    }

    //method closes all the object of ReslutSet
    public void closeResultSet(ResultSet reslutset) {
        try {
            if (reslutset != null) {
                reslutset.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SingleMaltQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
