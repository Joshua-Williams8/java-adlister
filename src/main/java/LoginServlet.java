import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    request.getRequestDispatcher("/login.jsp").forward(request, response);



    String testUser = request.getParameter("username");
    String testPass = request.getParameter("password");

    if (testUser == null || testPass == null) {
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    } else {

      String validUser = "testuser";
      String validPass = "testpass";

      if (testUser.equalsIgnoreCase(validUser) && testPass.equals(validPass)) {
        request.setAttribute("loggedIn", true);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);

      } else {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    request.getRequestDispatcher("/login.jsp").forward(request, response);



    String testUser = request.getParameter("username");
    String testPass = request.getParameter("password");

    if (testUser == null || testPass == null) {
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    } else {

      String validUser = "testuser";
      String validPass = "testpass";

      if (testUser.equalsIgnoreCase(validUser) && testPass.equals(validPass)) {
        request.setAttribute("loggedIn", true);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);

      } else {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
      }
    }
  }

}
