package com.hwangwongyu.news.user;

import com.hwangwongyu.news.redis.UserLoginInfo;

import java.util.List;

public interface UserService {

    List<UserDTO> allUsers();

    Integer addUser(UserDTO user);

    Integer updateUser(UserDTO user);

    Integer deleteUser(String loginId);

    UserDTO findUserById(long id);

    UserDTO loginUser(UserLoginInfo userLoginInfo);
}