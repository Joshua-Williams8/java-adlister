import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizzaOrder")
public class PizzaOrderServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//    request.getRequestDispatcher("/pizza-Order.jsp").forward(request,response);
    req.getRequestDispatcher("/pizza-Order.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    request.getRequestDispatcher("/pizza-Order.jsp").forward(request, response);

//    Make these select inputs

    String crustType = request.getParameter("crustType");
    String sauceType = request.getParameter("sauceType");
    System.out.println("Crust: ");
    System.out.println(crustType);
    System.out.println("");
    System.out.println("Sauce: ");
    System.out.println(sauceType);
    System.out.println("");

//  Make these topping checkboxes ? Should this be an array? or a true or false for each topping?
    String[] toppings = request.getParameterValues("toppings");

    System.out.println("Toppings below: ");
    for (String topping : toppings) {
      System.out.println(topping);
    }





// Text box
    String address = request.getParameter("address");

    System.out.println("Address: ");
    System.out.println(address);

  }

}
