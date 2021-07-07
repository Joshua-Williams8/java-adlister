import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/create")
public class CreateAdServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/ads/create.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ads adsDao = DaoFactory.getAdsDao();
    // create a new ad based on the submitted data
    long id = Long.parseLong(request.getParameter("id"));
    long userId = Long.parseLong(request.getParameter("userId"));
    String title = request.getParameter("title");
    String description = request.getParameter("description");
//    double price = Double.parseDouble(request.getParameter("price"));
    Ad ad = new Ad(id, userId, title,description);
    // persist the new ad
    adsDao.insert(ad);
    response.sendRedirect("/ads");
  }
}
