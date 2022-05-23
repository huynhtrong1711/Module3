package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import com.codegym.service.customer.impl.CustomerService;
import com.codegym.service.customer.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerService();
    private final ICustomerTypeService customerTypeService = new CustomerTypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "update":
                showUpdateCustomer(request, response);
                break;
            case "search" :
                searchCustomer(request, response);
                break;
            case "view" :
                showViewCustomer(request, response);
                break;
            default:
                showListCustomer(request,response);
                break;
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeLists = customerTypeService.findAll();
        request.setAttribute("customerTypeLists", customerTypeLists);
        int id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("customer_name");
        List<Customer> list = customerService.searchByName(name);
        request.setAttribute("customerList", list);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeListView = customerTypeService.findAll();
        request.setAttribute("customerTypeListView", customerTypeListView);
        int idView = Integer.parseInt(request.getParameter("customerId"));
        Customer customerView = this.customerService.findById(idView);
        request.setAttribute("customerView", customerView);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/view.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatchers = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatchers.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "update" :
                updateCustomer(request, response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerCode = request.getParameter("customer_code");
        String  nameCustomer = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        Customer customer = new Customer(customerCode,customerTypeId, nameCustomer, birthday,gender,customerIdCard,customerPhone,customerEmail,customerAddress);
        customerService.saveCustomer(customer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("customer_id"));
        String customer_code = request.getParameter("customer_code");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        boolean customer_gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
//        String customerTypeName = request.getParameter("customer_type_name");
        Customer customers = new Customer(id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id);
        customerService.updateCustomer(customers);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        try {
            response.sendRedirect("/customer");
        }catch (IOException e) {
            e.printStackTrace();
                }
    }
}
