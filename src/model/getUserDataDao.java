package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class getUserDataDao {
    beans beans = new beans();
    loginDao loginDao = new loginDao();
    public void doPost(HttpServletRequest request, HttpServletResponse respose) throws SQLException, ServletException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<beans> lbeans = new ArrayList<beans>();
        statement = connection.createStatement();

        //*user name and pasword from login
        String username = beans.getUserName();
        String password = beans.getPassWord();
        resultSet = statement.executeQuery("");
        while (resultSet.next()){
            lbeans.add(new beans(resultSet.getString("userName"),resultSet.getString("location")));
        }
        request.setAttribute("data", lbeans);
        String videwPage = "userDashboard.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(videwPage);
        if (dispatcher != null) {
            dispatcher.forward(request, respose);
        }
    }
}
