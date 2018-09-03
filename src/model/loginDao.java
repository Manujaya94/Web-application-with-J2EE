package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.beans;
public class loginDao {
    beans beans = new beans();
    public String authentication(beans beans){
        String username = beans.getUserName();
        String password = beans.getPassWord();
        String usernameDB = "";
        String passwordDB = "";
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            con = DbConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("");
            //*untile the next row is pressent
            while (resultSet.next()){
                usernameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password"); //*values have to be eqvivalent to the values in a database

                if(username.equals(usernameDB) && password.equals(passwordDB)){
                    return "SUCESS";
                }
                else {
                    return "FALSE0";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user data";
    }
}
