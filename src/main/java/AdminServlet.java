import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    try {
      boolean isAdmin = req.getParameter("isAdmin").equalsIgnoreCase("yes");
//    We're just checking if the string is equal to yes so admin is true for an example
      if (isAdmin) {
        out.println("<h1>Welcome Home, Admin.</h1>");
//      if it is TRUE then it will open the admin page and display this.

      } else {
        resp.sendRedirect("/hello-world");
//      If the isadmin is  NOT set to yes, it will send you back to hello world.
      }
    } catch (NullPointerException npe){
      resp.sendRedirect("/hello-world");
//      If it's null it goes back to hello-world also.
    }
//    http://localhost:8080/admin
//    http://localhost:8080/admin?isAdmin=yes
//    http://localhost:8080/admin?isAdmin=no

  }
}
