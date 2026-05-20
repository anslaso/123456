package com.anslaso.ssm.service.impl;

import com.anslaso.ssm.entity.Order;
import com.anslaso.ssm.mapper.OrderMapper;
import com.anslaso.ssm.mapper.CommodityMapper;
import com.anslaso.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderMapper orderMapper;

  @Autowired
  private CommodityMapper commodityMapper;

  /**
   * 创建订单：检查并扣库存、插入订单，整个过程事务性
   */
  @Override
  @Transactional
  public boolean createOrder(int userId, int commodityId, int quantity) {
    // 尝试扣库存
    int updated = commodityMapper.updateStock(java.util.Map.of("id", commodityId, "quantity", quantity));
    if (updated <= 0) {
      // 库存不足或更新失败
      return false;
    }
    Order order = new Order();
    order.setUserId(userId);
    order.setCommodityId(commodityId);
    order.setQuantity(quantity);
    order.setCreateTime(new Date());
    int inserted = orderMapper.insertOrder(order);
    return inserted > 0;
  }

  @Override
  public List<Order> findByUserId(int userId) {
    return orderMapper.selectByUserId(userId);
  }

  @Override
  public boolean deleteById(int id) {
    int d = orderMapper.deleteById(id);
    return d > 0;
  }
}
