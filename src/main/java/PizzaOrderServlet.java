import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizzaOrder")
//Above tag allows us to use this servlet with the pizzaOrder.
public class PizzaOrderServlet extends HttpServlet {
//  Just so we can use the http servlet class as our pizzaorder class
//  We override below so we can change how doGet works just for pizza order, and what it will do for us.
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//    request.getRequestDispatcher("/pizza-Order.jsp").forward(request,response);
//    We use below so we can direct our users to our jsp page, from this servlet.
    req.getRequestDispatcher("/pizza-Order.jsp").forward(req, resp);
  }
//Below is the same as above but it only accepts post values?
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    if (request.getMethod().equalsIgnoreCase("post")) { }
//    Do I need to wrap all of this code in the if above? so it only works with post? or is doPost default going to know?
    request.getRequestDispatcher("/pizza-Order.jsp").forward(request, response);
//    Sends our page to our jsp.

//    Make these select inputs
//    We are  grabbing the post parameters and putting them into Strings, to output to the console.
    String crustType = request.getParameter("crustType");
    String sauceType = request.getParameter("sauceType");
    System.out.print("Crust: ");
    System.out.println(crustType);
    System.out.println("");
    System.out.println("Sauce: ");
    System.out.print(sauceType);
    System.out.println("");

//  Make these topping checkboxes ? Should this be an array? or a true or false for each topping?
//    Inorder to grab an array of values, we need ot use the method below instead of the one from above.
    String[] toppings = request.getParameterValues("toppings");
//Enchanced for loop to display what toppings were chosen.
    System.out.println("Toppings below: ");
    for (String topping : toppings) {
      System.out.println(topping);
    }




//Below just grabs the value out of the address text
//    TODO refactor so it takes each piece in a Street:, City:, State:, Zip: format.
// Text box
    String address = request.getParameter("address");

    System.out.println("Address: ");
    System.out.println(address);

  }

}
