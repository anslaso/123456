package com.anslaso.ssm.entity;

import java.math.BigDecimal;

public class Commodity {
  private Integer id;
  private String name;
  private BigDecimal price;
  private Integer stock;
  private String description;

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }
  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
}
