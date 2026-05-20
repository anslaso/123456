package com.anslaso.ssm.service.impl;

import com.anslaso.ssm.entity.User;
import com.anslaso.ssm.mapper.UserMapper;
import com.anslaso.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public User login(String username, String password) {
    User u = userMapper.selectByUsername(username);
    if (u != null && u.getPassword().equals(password)) {
      return u;
    }
    return null;
  }

  @Override
  public User findById(int id) {
    return userMapper.selectById(id);
  }
}
