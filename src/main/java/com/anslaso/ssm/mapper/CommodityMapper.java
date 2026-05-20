package com.anslaso.ssm.mapper;

import com.anslaso.ssm.entity.Commodity;
import java.util.List;
import java.util.Map;

public interface CommodityMapper {
  int selectCount();
  List<Commodity> selectPage(Map<String, Object> params);
  Commodity selectById(int id);
  int updateStock(Map<String, Object> params);
  int setStock(Map<String, Object> params);
}
