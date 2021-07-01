import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      String name = request.getParameter("name");
//      request.setAttribute("helloToName",name);
      request.setAttribute("name",name);
      request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request,response);


    }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String name = request.getParameter("name");
//      request.setAttribute("helloToName",name);
    request.setAttribute("name",name);
    request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request,response);


  }
}
