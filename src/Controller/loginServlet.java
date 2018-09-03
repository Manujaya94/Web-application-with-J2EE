package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.beans;
import model.loginDao;

public class loginServlet extends HttpServlet {
    public loginServlet(){
    }
    protected void doPost(HttpServletRequest requse, HttpServletResponse response) throws ServletException, IOException {
        String userName = requse.getParameter("username");
        String password = requse.getParameter("password");
        beans beans = new beans();
        beans.setUserName(userName);
        beans.setPassWord(password);

        loginDao loginDao = new loginDao();
        String userValidation = loginDao.authentication(beans);
        if(userValidation.equals("SUCESS")){
            requse.setAttribute("username", userName);
            requse.getRequestDispatcher("user.jsp").forward(requse, response);;
        }
        else {
            requse.setAttribute("errorMessage", userValidation);
            requse.getRequestDispatcher("loginHtml.jsp").forward(requse, response);
        }
    }
}
