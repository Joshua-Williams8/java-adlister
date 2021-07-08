import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "NameOfServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    HttpSession session = request.getSession();
    session.setAttribute("isAdmin",false);
    session.setAttribute("user",false);
    response.sendRedirect("/login");

  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    HttpSession session = request.getSession();
    session.setAttribute("isAdmin",false);
    session.setAttribute("user",false);
    response.sendRedirect("/login");

  }
}