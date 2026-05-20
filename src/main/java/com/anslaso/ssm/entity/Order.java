package com.anslaso.ssm.entity;

import java.util.Date;

public class Order {
  private Integer id;
  private Integer userId;
  private Integer commodityId;
  private Integer quantity;
  private Date createTime;

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public Integer getUserId() { return userId; }
  public void setUserId(Integer userId) { this.userId = userId; }
  public Integer getCommodityId() { return commodityId; }
  public void setCommodityId(Integer commodityId) { this.commodityId = commodityId; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
  public Date getCreateTime() { return createTime; }
  public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
