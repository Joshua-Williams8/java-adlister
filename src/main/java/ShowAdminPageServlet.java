import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "NameOfServlet", urlPatterns = "/adminpage")
public class ShowAdminPageServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    HttpSession session = request.getSession();
    Boolean isAdminBool = (Boolean) session.getAttribute("isAdmin");
//    I want to make sure I return the correct object when we get this object, remember this always have ot EXPLICITLY get casted to the type we want it to be.
    if (!isAdminBool){
      response.sendRedirect("/login");
      return;
//      Need the return here so we don't always go to below? and we won't have to request login again?
    }

    request.getRequestDispatcher("/secret-admin-page.jsp").forward(request,response);





  }
}
