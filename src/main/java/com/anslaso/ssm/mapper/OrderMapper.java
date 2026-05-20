package com.anslaso.ssm.mapper;

import com.anslaso.ssm.entity.Order;
import java.util.List;

public interface OrderMapper {
  int insertOrder(Order order);
  java.util.List<Order> selectByUserId(int userId);
  int deleteById(int id);
}
