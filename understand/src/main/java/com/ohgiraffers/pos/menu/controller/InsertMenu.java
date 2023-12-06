package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("/insert")
public class InsertMenu {
    @Autowired
    private MenuService menuService;
    // localhost:8080/insert
    @GetMapping
    public String insertMenu(){
        return "menu/insertMenu";
    };
    // localhost:8080/insert/insert-menu
    @PostMapping("/insert-menu")
    public String insertMenu(MenuDTO menuDTO){
        menuService.insertMenu(menuDTO);

        return "redirect:/";
        //index.html로 redirect
    }
}
