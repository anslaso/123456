package com.anslaso.ssm.service;

import com.anslaso.ssm.entity.User;

public interface UserService {
  User login(String username, String password);
  User findById(int id);
}
