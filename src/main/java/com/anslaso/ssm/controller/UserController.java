package com.anslaso.ssm.controller;

import com.anslaso.ssm.entity.User;
import com.anslaso.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String loginPage(Model model, HttpSession session) {
    Object err = session.getAttribute("loginError");
    if (err != null) {
      model.addAttribute("loginError", err);
      session.removeAttribute("loginError");
    }
    return "login";
  }

  @PostMapping("/login")
  public String doLogin(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
    User u = userService.login(username, password);
    if (u != null) {
      session.setAttribute("currentUser", u);
      return "redirect:/commodity/list";
    } else {
      session.setAttribute("loginError", "用户名或密码错误");
      return "redirect:/user/login";
    }
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/user/login";
  }
}
