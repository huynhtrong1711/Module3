package com.codegym.service.impl;

import com.codegym.model.Users;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.impl.UserRepository;
import com.codegym.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<Users> getAllUser() {
        List<Users> usersList = iUserRepository.getAllUser();
        if(usersList.size()==0) {
            return null;
        } else {
            return iUserRepository.getAllUser();
        }
    }

    @Override
    public void saveUser(Users users) {
        iUserRepository.saveUser(users);
    }

    @Override
    public Users findByCodeUser(int id) {
        return iUserRepository.findByCodeUser(id);
    }

    @Override
    public void updateUser(Users users) {
        iUserRepository.updateUser(users);
    }


    @Override
    public void deleteUser(int id) {
        iUserRepository.deleteCodeUser(id);
    }
}
