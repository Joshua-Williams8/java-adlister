import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ViewColorServlet", urlPatterns = "/viewColor")
public class ViewColorServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//    request.getRequestDispatcher("/pizza-Order.jsp").forward(request,response);
    String color = req.getParameter("chosenColor");
    System.out.printf("%s was entered.\n", color);

    req.getRequestDispatcher("/viewColor.jsp").forward(req, resp);



  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
    String color = request.getParameter("chosenColor");
//
    request.setAttribute("chosenColor",color);

    System.out.printf("%s was entered.\n", color);
    request.getRequestDispatcher("/viewColor.jsp").forward(request, response);


  }
}
