package com.anslaso.ssm.controller;

import com.anslaso.ssm.entity.Commodity;
import com.anslaso.ssm.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
  @Autowired
  private CommodityService commodityService;

  @GetMapping({"/list", "/"})
  public String list(@RequestParam(value="page", defaultValue="1") int page,
                     @RequestParam(value="pageSize", defaultValue="5") int pageSize,
                     Model model) {
    int total = commodityService.count();
    List<Commodity> items = commodityService.findPage(page, pageSize);
    int totalPages = (total + pageSize - 1) / pageSize;
    model.addAttribute("items", items);
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", totalPages);
    model.addAttribute("pageSize", pageSize);
    return "commodity-list";
  }

  @GetMapping("/detail/{id}")
  public String detail(@PathVariable("id") int id, Model model) {
    Commodity c = commodityService.findById(id);
    model.addAttribute("commodity", c);
    return "commodity-detail";
  }
}
