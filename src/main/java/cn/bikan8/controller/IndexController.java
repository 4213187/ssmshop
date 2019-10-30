package cn.bikan8.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Random;

@Controller
public class IndexController {


    @RequestMapping("/adminLogin")
    protected String IndexController(ModelMap modelMap) {
        Random r = new Random();
        int x = r.nextInt(3) + 1;
        return "redirect:/admin/login"+x+".jsp";

    }
}
