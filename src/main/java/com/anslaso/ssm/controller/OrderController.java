package com.anslaso.ssm.controller;

import com.anslaso.ssm.entity.Order;
import com.anslaso.ssm.entity.User;
import com.anslaso.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("/create")
  public String create(@RequestParam int commodityId,
                       @RequestParam int quantity,
                       HttpSession session,
                       Model model) {
    User u = (User) session.getAttribute("currentUser");
    if (u == null) {
      session.setAttribute("loginError", "请先登录");
      return "redirect:/user/login";
    }
    boolean ok = orderService.createOrder(u.getId(), commodityId, quantity);
    if (ok) {
      return "redirect:/order/list";
    } else {
      model.addAttribute("error", "下单失败，可能库存不足");
      return "commodity-detail";
    }
  }

  @GetMapping("/list")
  public String list(HttpSession session, Model model) {
    User u = (User) session.getAttribute("currentUser");
    if (u == null) {
      session.setAttribute("loginError", "请先登录");
      return "redirect:/user/login";
    }
    List<Order> orders = orderService.findByUserId(u.getId());
    model.addAttribute("orders", orders);
    return "order-list";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable int id, HttpSession session) {
    User u = (User) session.getAttribute("currentUser");
    if (u == null) {
      session.setAttribute("loginError", "请先登录");
      return "redirect:/user/login";
    }
    orderService.deleteById(id);
    return "redirect:/order/list";
  }
}
