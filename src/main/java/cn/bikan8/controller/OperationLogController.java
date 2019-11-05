package cn.bikan8.controller;

import cn.bikan8.entity.OperationLog;
import cn.bikan8.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 小浩
 * @Date 2019/11/4 13:26
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class OperationLogController {
    @Autowired
    OperationLogService operationLogService;

    @RequestMapping("/admin.findAllOperationLog")
    public String findAllOperationLog(ModelMap map) {
        List<OperationLog> operationLogs = operationLogService.findAll();
        map.addAttribute("operationLogs", operationLogs);
        return "admin_operationlog_list.jsp";

    }

}

