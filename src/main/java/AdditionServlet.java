import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdditionServlet", urlPatterns = "/add")
public class AdditionServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      int num1 = Integer.parseInt(req.getParameter("num1"));
//      int num2 = Integer.parseInt(req.getParameter("num2"));

      int num1 = 0;
      int num2 = 0;

      resp.setContentType("text/html");
      PrintWriter out = resp.getWriter();

      try{
        num1 = Integer.parseInt(req.getParameter("num1"));
      } catch(NumberFormatException nfe) {
        out.println("You didn't give us an integer, for num 1");
      }

      try{
        num2 = Integer.parseInt(req.getParameter("num2"));
      } catch(NumberFormatException nfe) {
        out.println("You didn't give us an integer, for num 2");
      }


      out.println("<h1>" + num1 + " + " + num2 + " = " + (num1 + num2) + "</h1>");
//    Links for testing outcomes below.
//    http://localhost:8080/add
//    http://localhost:8080/add?num1=3
//    http://localhost:8080/add?num1=3&num2=5

    }
  }

