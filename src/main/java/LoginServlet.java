import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    boolean isAdmin = username.equals("admin") && password.equals("password");
    boolean user = username.equals("user") && password.equals("password");

    HttpSession session = request.getSession();


    if (isAdmin) {
      session.setAttribute("isAdmin", true);
      response.sendRedirect("/adminpage");
    } else if (user) {
      session.setAttribute("user", true);
      session.setAttribute("username", request.getParameter("username"));
      response.sendRedirect("/profile");
    } else {
      response.sendRedirect("/login");
    }
  }
}


//        Session notes below
//    HttpSession session = request.getSession();
//    String darkMode = request.getParameter("color");
////    session.setAttribute("color",color);
//
//    session.setAttribute("darkMode",darkMode);
////    We can use it as a variable and apply it somewhere to make it it gets applied
////    Sets our dark theme attribute on the session so that it gets remembered every time we log in.
//// Above gets returned as an object, and we have to EXPLICITLY CAST it to the correct type.
//    String darkSet = (String) session.getAttribute("darkMode");
//
////    Destroys the session
//    session.invalidate();

//    Cookies are always being tracked inside the browser, while the session is tracked by the server...


