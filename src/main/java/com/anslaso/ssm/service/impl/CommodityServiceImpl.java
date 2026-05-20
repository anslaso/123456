package com.anslaso.ssm.service.impl;

import com.anslaso.ssm.entity.Commodity;
import com.anslaso.ssm.mapper.CommodityMapper;
import com.anslaso.ssm.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CommodityServiceImpl implements CommodityService {
  @Autowired
  private CommodityMapper commodityMapper;

  @Override
  public int count() {
    return commodityMapper.selectCount();
  }

  @Override
  public List<Commodity> findPage(int page, int pageSize) {
    int offset = (page - 1) * pageSize;
    Map<String,Object> params = new HashMap<>();
    params.put("offset", offset);
    params.put("limit", pageSize);
    return commodityMapper.selectPage(params);
  }

  @Override
  public Commodity findById(int id) {
    return commodityMapper.selectById(id);
  }

  @Override
  public boolean decreaseStock(int id, int quantity) {
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    params.put("quantity", quantity);
    int updated = commodityMapper.updateStock(params);
    return updated > 0;
  }

  @Override
  public boolean setStock(int id, int stock) {
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    params.put("stock", stock);
    int updated = commodityMapper.setStock(params);
    return updated > 0;
  }
}
