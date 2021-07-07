import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    boolean loggedIn = false;

    loggedIn = (boolean) request.getAttribute("loggedIn");


    if (loggedIn) {

      request.getRequestDispatcher("/profile.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getAttribute("loggedIn") != null) {

      boolean loggedIn = (boolean) request.getAttribute("loggedIn");
      if (loggedIn) {

        request.getRequestDispatcher("/profile.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
      }
    } else {
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }


}
