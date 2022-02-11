import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("list"));
        float discount = Float.parseFloat(request.getParameter("discount"));

        float discountAmount = (float) (price * discount * 0.01);
        float discountPrice = price - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product Description:" + product + "</h1>");
        writer.println("<h1> List Price:" + price+ "</h1>");
        writer.println("<h1> Discount Amount:" + discountAmount + "</h1>");
        writer.println("<h1> Discount Price:" + discountPrice + "</h1>");
        writer.println("</html>");

    }
}
