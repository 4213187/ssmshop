package cn.bikan8.controller;


import cn.bikan8.entity.AdminLog;
import cn.bikan8.service.AdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 小浩
 */
@Controller
@RequestMapping("/admin")
public class AdminLogController {
    @Autowired
    AdminLogService adminLogService;

    @RequestMapping("/admin.findAllLog")
    public  String findAllLog(ModelMap map) {
        List<AdminLog> adminLogs = adminLogService.findAll();
        map.addAttribute("adminLogs", adminLogs);
        return "admin_log_list.jsp";

    }

    @RequestMapping("/admin.findLogByAname")
    public  String findByAname(String aname ,ModelMap map) {

        List<AdminLog> adminLogs = adminLogService.findByAname(aname);

        map.addAttribute("adminLogs", adminLogs);
        return "person_log_list.jsp";

    }



}
