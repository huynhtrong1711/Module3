package com.codegym.controller;

import com.codegym.model.Users;
import com.codegym.service.IUserService;
import com.codegym.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/usersE")
public class UsersServlet extends HttpServlet {
    private IUserService iUsersService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/user/create.jsp").forward(request, response);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Users users = iUsersService.findByCodeUser(id);
                request.setAttribute("users", users);
                request.setAttribute("message", "Product information was updated");
                request.getRequestDispatcher("/user/update.jsp").forward(request, response);
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                Users usersDe = iUsersService.findByCodeUser(idDelete);
                request.setAttribute("userDelete", usersDe);
                request.getRequestDispatcher("/user/delete.jsp").forward(request, response);
                break;
            case "search" :
                String country = request.getParameter("country");
                List<Users> list = iUsersService.searchByName(country);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/user/list.jsp").forward(request, response);
                break;
            default: {
                List<Users> usersList = iUsersService.getAllUser();
                request.setAttribute("list", usersList);
                request.getRequestDispatcher("/user/list.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                String name = request.getParameter("name_user");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                Users users = new Users( name, email, country);
                iUsersService.saveUser(users);
                response.sendRedirect("/usersE");
                break;
            }
            case "update": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name_user");
                String country = request.getParameter("country");
                String email = request.getParameter("email");
                Users users = new Users(id,name, email, country);
                iUsersService.updateUser(users);
                response.sendRedirect("/usersE");
                break;

            }
            case "delete": {
                int idDelete = Integer.parseInt(request.getParameter("id"));
//                String nameD = request.getParameter("name_user");
//                String countryD = request.getParameter("country");
//                String emailD = request.getParameter("email");
//                Users users = new Users(idDelete,nameD, emailD, countryD);
                iUsersService.deleteUser(idDelete);
                response.sendRedirect("/usersE");
                break;
            }
        }
    }
}
