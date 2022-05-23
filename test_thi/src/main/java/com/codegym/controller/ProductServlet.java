package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.ICategoryService;
import com.codegym.service.IProductService;
import com.codegym.service.impl.CategoryService;
import com.codegym.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final IProductService iProductService = new ProductService();
    private final ICategoryService iCategoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update" :
                showUpdate(request, response);
                break;
            case "searchByName" :
                searchByName(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> productList = iProductService.searchByName(name);
        request.setAttribute("productList", productList);
        List<Category> categoryList = iCategoryService.findALL();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = iCategoryService.findALL();
        request.setAttribute("categoryList", categoryList);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = iCategoryService.findALL();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.findAll();
        request.setAttribute("productList", productList);
        List<Category> categoryList = iCategoryService.findALL();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
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
            case "create" :
                createProduct(request, response);
                break;
            case "update" :
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name_product");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("id_categogy"));
        Product product = new Product(id,name,price, amount,color,description,id_category);
        iProductService.updateProduct(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        iProductService.delete(id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String nameProduct = request.getParameter("name_product");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("id_categogy"));
        Product product = new Product(nameProduct,price,amount,color,description,idCategory);
        iProductService.saveProduct(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
