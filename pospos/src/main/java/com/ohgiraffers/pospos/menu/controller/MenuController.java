package com.ohgiraffers.pospos.menu.controller;

import com.ohgiraffers.pospos.menu.dto.MenuDTO;
import com.ohgiraffers.pospos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ModelAndView selectAllMenu(ModelAndView mv){
        List<MenuDTO> menus = menuService.selectAllMenu();

        if(Objects.isNull(menus)){
            System.out.println("exception으로 대처한다");
        }
        mv.addObject("menus",menus);
        mv.setViewName("menu/allMenus");
        return mv;
    }

    @GetMapping("/insert-menu")
    public String insertMenu(){
        return "menu/insertMenu";
    };

    @PostMapping("/insert")
    public ModelAndView insertMenu(ModelAndView mv,MenuDTO menuDTO){
        int result = menuService.insertMenu(menuDTO);
        if(result>=0){
            mv.setViewName("/menu/successMessage");
        }

        return mv;
    }
}
