package com.codegym.service;

import com.codegym.model.Users;

import java.util.List;

public interface IUserService {

    List<Users> getAllUser();

    void saveUser(Users users);

    Users findByCodeUser(int id);

    void updateUser(Users users);

    void deleteUser(int id);

    List<Users> searchByName(String country);
}
