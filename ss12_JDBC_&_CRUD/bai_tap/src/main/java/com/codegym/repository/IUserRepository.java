package com.codegym.repository;

import com.codegym.model.Users;

import java.util.List;

public interface IUserRepository {
    List<Users> getAllUser();

    void saveUser(Users users);

    Users findByCodeUser(int id);

    void updateUser(Users users);

    void deleteCodeUser(int id);

    List<Users> searchByName(String country);
}
