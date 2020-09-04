package com.example.hw01cst438.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from User")
    List<User> getAllUsers();

    @Query("select * from User where username = :username")
    List<User> getUserByUsername(String username);

    @Query("select * from User where username = :username and password = :password")
    List<User> getUserByUsernamePassword(String username, String password);

    @Insert
    long addUser(User user);
}
