package cn.bikan8.controller;

import cn.bikan8.service.OperationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 小浩
 * @Date 2019/11/4 13:37
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class OperationDataController {
    @Autowired
    OperationDataService operationDataService;

    @RequestMapping("/admin.rollback")
    public  String rollback(String uuid ){
        operationDataService.rollbackFor(uuid);
        return "redirect:admin.findAllOperationLog";
    }
}
