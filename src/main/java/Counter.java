import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class Counter extends HttpServlet {
  private int count;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    String reset = "no";
//    Just giving reset a default value doesn't matter but it needs to be declared

    reset = req.getParameter("reset");
//    Assuming reset is a parameter in the request, it will need to have a yes to reset the count.
//    If reset is not yes, then it will display the amount of times the page was visited and add 1.
//    If reset is null, then it will do the same as above.


    try{
      if(reset.equalsIgnoreCase("yes")){
        count = 0;
        count = count + 1;
        out.println("<h1>You have reset your counter to " + count + "</h1>");
      } else {
        count = count + 1;
        out.println("<h1>This is how many times you've visited: " + count + "</h1>");
      }

    } catch (NullPointerException npe){
//      out.println("<h1>Error</h1>");
      count = count + 1;
      out.println("<h1>This is how many times you've visited: " + count + "</h1>");


    }


  }
}
