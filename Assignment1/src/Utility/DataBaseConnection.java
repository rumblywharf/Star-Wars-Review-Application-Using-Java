package Utility;
import Model.StarWarsModel;
import java.sql.*;
import java.util.ArrayList;

public class DataBaseConnection {
        public static ArrayList<StarWarsModel> getAll() throws SQLException {
            Connection conn = null;
            Statement statement = null;
            ResultSet rs = null;
            ArrayList<StarWarsModel> starWarsModelArrayList = new ArrayList<StarWarsModel>();

            try {
                //1.    connect to the DB
                conn = DriverManager.getConnection("jdbc:mysql://172.31.22.43:3306/Cameron1106175?serverTimezone=EST", "Cameron1106175", "XQx351esJC");
                //2.    create the sql statement object
                statement = conn.createStatement();
                //3.    create/execute the sql query
                rs = statement.executeQuery("SELECT * FROM StarWars");
                //4. get the metadata to display column headers
                ResultSetMetaData metaData = rs.getMetaData();
                while(rs.next()){
                    StarWarsModel starWarsModel = new StarWarsModel(rs.getString("Title"), rs.getInt("Revenue"), rs.getInt("Rating"));
                    starWarsModelArrayList.add(starWarsModel);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if (conn != null)
                    conn.close();
                if (statement != null)
                    statement.close();
                if (rs != null)
                    rs.close();
            }
            return starWarsModelArrayList;
        }
    }
