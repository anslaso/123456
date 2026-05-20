package com.anslaso.ssm.service;

import com.anslaso.ssm.entity.Commodity;
import java.util.List;

public interface CommodityService {
  int count();
  List<Commodity> findPage(int page, int pageSize);
  Commodity findById(int id);
  boolean decreaseStock(int id, int quantity);
  boolean setStock(int id, int stock);
}
