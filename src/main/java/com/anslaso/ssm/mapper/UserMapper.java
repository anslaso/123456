package com.anslaso.ssm.mapper;

import com.anslaso.ssm.entity.User;

public interface UserMapper {
  User selectByUsername(String username);
  User selectById(int id);
}
