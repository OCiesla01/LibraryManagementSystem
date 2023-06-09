package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.Role;
import com.oc01.springbootlibrarymanagementsystem.entity.User;
import com.oc01.springbootlibrarymanagementsystem.service.RoleService;
import com.oc01.springbootlibrarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;
    private UserService userService;

    @Autowired
    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/list")
    private String roleList(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);

        return "role/roles-list";
    }
}
