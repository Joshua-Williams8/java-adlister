import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PickColorServlet", urlPatterns = "/pickColor")
public class PickColorServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//    request.getRequestDispatcher("/pizza-Order.jsp").forward(request,response);
    req.getRequestDispatcher("/pickColor.jsp").forward(req, resp);


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    request.getRequestDispatcher("/pickColor.jsp").forward(request, response);


  }



}
