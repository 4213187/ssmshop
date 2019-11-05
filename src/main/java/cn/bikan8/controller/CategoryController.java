package cn.bikan8.controller;

import cn.bikan8.entity.Category;
import cn.bikan8.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author 小浩
 * @Date 2019/11/5 8:08
 * @Version 1.0
 **/

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/category.findAll")
    public List<Category> findAll() {
        List<Category> categories = categoryService.findAll();
        return categories;

    }

    @RequestMapping("/category.addRoot")
    public String addRoot(String name, String descr) {
        Category category = new Category();
        category.setName(name);
        category.setDescr(descr);
        categoryService.addRoot(category);
        return "redirect:category_list.jsp";

    }

    @RequestMapping("/category.toAddChildren")
    public String toAddChildren(int id, ModelMap map) {
        Category category = categoryService.findById(id);
        System.out.println(category);
        map.addAttribute("category", category);
        return "add_category_child.jsp";

    }

    @RequestMapping("/category.addChildren")
    public String addChildren(int pid ,int grade , String name, String  descr) {
        Category category = new Category();
        category.setDescr(descr);
        category.setName(name);
        category.setGrade(grade);
        category.setPid(pid);

        // 添加新结点
        categoryService.addChild(category);
        return  "redirect:category_list.jsp";

    }

    @RequestMapping("/category.toupdate")
    public  String toupdate(int id,ModelMap map){
        Category category = categoryService.findById(id);
        map.addAttribute("category",category);
        return "update_category.jsp";
    }
    @RequestMapping("/category.update")
    public  String update(int id , String name,String  descr){
        Category category = categoryService.findById(id);
        category.setName(name);
        category.setDescr(descr);
        categoryService.updateInfo(category);
        return  "redirect:category_list.jsp";
    }

}
