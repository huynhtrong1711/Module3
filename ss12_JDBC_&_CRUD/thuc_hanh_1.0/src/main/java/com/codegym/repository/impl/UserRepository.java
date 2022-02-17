package com.codegym.repository.impl;

import com.codegym.model.Users;
import com.codegym.repository.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private  BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Users> getAllUser() {
        List<Users> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            Users users;

            while (resultSet.next()) {
                users = new Users();
                users.setId(resultSet.getInt("id_user"));
                users.setName(resultSet.getString("name_user"));
                users.setEmail(resultSet.getString("email"));
                users.setCountry(resultSet.getString("country"));
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveUser(Users users) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into users(name_user, email, country) value (?,?,?)");
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users findByCodeUser(int id) {
        Users users = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from users where id_user = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users = new Users();
                users.setId(id);
                users.setName(resultSet.getString("name_user"));
                users.setEmail(resultSet.getString("email"));
                users.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(Users users) {

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update users set name_user = ?, email = ?, country = ? where id_user = ?");
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getCountry());
            preparedStatement.setInt(4, users.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCodeUser(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from users where id_user = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
