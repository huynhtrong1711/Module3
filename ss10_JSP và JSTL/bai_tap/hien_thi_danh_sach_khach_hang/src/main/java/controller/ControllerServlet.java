package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/customers")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("1","Lionel Messi","24-06-1987", "Argentina","https://i.pinimg.com/736x/42/31/83/4231837f09252cc206a79c6c901a0d1f.jpg"));
        customerList.add(new Customer("2","Cristiano Ronaldo","05-02-1985", "Bồ Đào Nha","https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg"));
        customerList.add(new Customer("3","Neymar da Silva","05-02-1992", "Brazil","https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Bra-Cos_%281%29.jpg/800px-Bra-Cos_%281%29.jpg"));
        customerList.add(new Customer("4","Kylian Mbappé Lottin ","20-02-1998", "Pháp","https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/2019-07-17_SG_Dynamo_Dresden_vs._Paris_Saint-Germain_by_Sandro_Halank%E2%80%93129_%28cropped%29.jpg/800px-2019-07-17_SG_Dynamo_Dresden_vs._Paris_Saint-Germain_by_Sandro_Halank%E2%80%93129_%28cropped%29.jpg"));
        customerList.add(new Customer("5","Erling Braut Haaland","21-07-2000", "Na Uy","https://kenh14cdn.com/thumb_w/660/2020/2/21/photo-2-15822439558822143905531.jpg"));

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/customer/customer_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
