package cn.bikan8.controller;


import cn.bikan8.entity.User;
import cn.bikan8.service.UserService;
import cn.bikan8.util.RandomCodeUtil;
import cn.bikan8.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author 小浩
 * @Date 2019/11/5 9:19
 * @Version 1.0
 **/

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user.findAll")
    public String findAll(ModelMap map) {
        List<User> users = userService.findAll();
        map.addAttribute("users", users);
        return "user_list.jsp";
    }

    @RequestMapping("/user.resetPassword")
    public String resetPassword(int id) {
        User user = userService.findById(id);
        userService.resetPassword(user);

        return "redirect:UserServlet?method=findAll";
    }

    @RequestMapping("/user.toUpdate")
    public String toUpdate(int id, ModelMap map) {
        User user = userService.findById(id);
        map.addAttribute("user", user);
        return "update_user.jsp";
    }
    @RequestMapping("/user.updateInfo")
    public String updateInfo(int id,String expiryDate,int disabled){
        User user = userService.findById(id);
        user.setVip(1);
        user.setDisabled(disabled);

        if (expiryDate!=null &&!expiryDate.equals("")){
            user.setExpiryDate(Timestamp.valueOf(expiryDate));

        }else {
            user.setExpiryDate(null);
        }
        userService.updateInfo(user);

        return "redirect:user.findAll";

    }


}
