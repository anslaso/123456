package com.anslaso.ssm.service;

import com.anslaso.ssm.entity.Order;
import java.util.List;

public interface OrderService {
  boolean createOrder(int userId, int commodityId, int quantity);
  List<Order> findByUserId(int userId);
  boolean deleteById(int id);
}
