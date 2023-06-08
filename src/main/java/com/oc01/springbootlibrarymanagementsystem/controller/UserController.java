package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.Role;
import com.oc01.springbootlibrarymanagementsystem.entity.User;
import com.oc01.springbootlibrarymanagementsystem.service.RoleService;
import com.oc01.springbootlibrarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.time.LocalDate.now;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    private UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/list")
    private String userList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "user/users-list";
    }

    @GetMapping("/{userId}")
    private String userDetails(@PathVariable("userId") int userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);

        return "user/user-details";
    }

    @GetMapping("/create-user")
    private String createUser(Model model) {
        User user = new User();
        user.setRegisteredSince(LocalDate.now());
        user.setRole(new Role("CUSTOMER"));
        user.setCurrentBooksLoaned(0);
        user.setTotalBooksLoaned(0);
        model.addAttribute("user", user);

        return "user/user-form";
    }

    @GetMapping("/update-user")
    private String updateUser(@RequestParam("userId") int userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);

        return "user/user-form";
    }

    @GetMapping("/delete")
    private String deleteUser(@RequestParam("userId") int userId) {
        userService.deleteById(userId);

        return "redirect:/users/list";
    }

    @PostMapping("/save")
    private String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/users/list";
    }

    @GetMapping("/assign-role")
    private String assignRole(@RequestParam("userId") int userId, Model model) {
        User user = userService.findById(userId);
        List<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "user/user-assign-role-form";
    }

    @PostMapping("/save-assigned-role")
    private String saveAssignedRole(@RequestParam("userId") int userId, @RequestParam("role") Role role) {
        User user = userService.findById(userId);
        user.setRole(role);
        userService.save(user);

        return "redirect:/users/list";
    }
}
