package com.nest.ComplaintApp_backend.dao;

import com.nest.ComplaintApp_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`= :username AND`password`= :password",nativeQuery = true)
    List<UserModel>UserLogin(@Param("username")String username,@Param("password")String password);

    @Query(value ="SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`= :username",nativeQuery = true)
    List<UserModel>FindUser(@Param("username")String username);




}
