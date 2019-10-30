package cn.bikan8.controller;

import cn.bikan8.entity.Admin;
import cn.bikan8.entity.AdminLog;
import cn.bikan8.entity.OperationData;
import cn.bikan8.entity.OperationLog;
import cn.bikan8.service.AdminService;
import cn.bikan8.service.impl.AdminServiceImpl;
import cn.bikan8.util.IpUtil;
import cn.bikan8.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author 小浩
 * @date 2019/10/24 15:50
 */
/*
                             _ooOoo_
                            o8888888o
                            88" . "88
                            (| -_- |)
                            O\  =  /O
                         ____/`---'\____
                       .'  \\|     |//  `.
                      /  \\|||  :  |||//  \
                     /  _||||| -:- |||||-  \
                     |   | \\\  -  /// |   |
                     | \_|  ''\---/''  |   |
                     \  .-\__  `-`  ___/-. /
                   ___`. .'  /--.--\  `. . __
                ."" '<  `.___\_<|>_/___.'  >'"".
               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
               \  \ `-.   \_ __\ /__ _/   .-` /  /
          ======`-.____`-.___\_____/___.-`____.-'======
                             `=---='
          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                     佛祖保佑        永无BUG
            佛曰:
                   写字楼里写字间，写字间里程序员；
                   程序人员写程序，又拿程序换酒钱。
                   酒醒只在网上坐，酒醉还来网下眠；
                   酒醉酒醒日复日，网上网下年复年。
                   但愿老死电脑间，不愿鞠躬老板前；
                   奔驰宝马贵者趣，公交自行程序员。
                   别人笑我忒疯癫，我笑自己命太贱；
                   不见满街漂亮妹，哪个归得程序员？
*/

@Controller()
public class AdminController {
    @Autowired
    private AdminService adminService;


    @RequestMapping("/admin/admin.login")
    public String login(String index, String aname, String apwd, ModelMap map, HttpServletRequest request) {

        Admin admin = adminService.login(aname, apwd, request);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            return "redirect:index.jsp";
        } else {
            map.addAttribute("msg", "登陆失败");
            return "login" + index + ".jsp";
        }
    }

    @RequestMapping("/admin/admin.findAll")
    public String findAll(ModelMap map, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        List<Admin> admins = adminService.findAll(admin.getGrade());
        map.addAttribute("admins", admins);
        return "admins.jsp";
    }

    @RequestMapping("/admin/admin.delete")
    public String delete(int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin Admin = (Admin) session.getAttribute("admin");
        Admin admin = adminService.findById(id);
        //           添加删除之前的数据保存到数据表
        OperationData operationData = new OperationData();
        operationData.setUuid(UUIDUtil.getUUID());
        operationData.setAdminId(admin.getId());
        operationData.setAdminAname(admin.getAname());
        operationData.setAdminApwd(admin.getApwd());
        operationData.setAdminDisabled(admin.getDisabled());
        operationData.setAdminGrade(admin.getGrade());
        //          添加删除日志到日志表
        OperationLog operationLog = new OperationLog();
        operationLog.setUuid(operationData.getUuid());
        operationLog.setOperator(Admin.getAname());
        operationLog.setObject(admin.getAname());
        operationLog.setIp(IpUtil.getIpAddress(request));
        operationLog.setContent("删除了一个账号为:" + admin.getAname() + "的管理员");
        operationLog.setType("删除管理员");
        //          删除操作
        adminService.delete(id, operationData, operationLog);
        return "redirect:admin.findAll";


    }

    @RequestMapping("/admin/admin.add")
    public String add(String aname, String apwd, int grade, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin Admin = (Admin) session.getAttribute("admin");
        Admin admin = new Admin();
        admin.setAname(aname);
        admin.setApwd(apwd);
        admin.setGrade(grade);
        admin.setDisabled(0);
        //          添加增加日志到日志表
        OperationLog operationLog = new OperationLog();
        operationLog.setUuid(UUIDUtil.getUUID());
        operationLog.setType("增加管理员");
        operationLog.setContent("增加了一个账号为:" + admin.getAname() + "的管理员");
        operationLog.setIp(IpUtil.getIpAddress(request));
        operationLog.setObject(admin.getAname());
        operationLog.setOperator(Admin.getAname());
//      添加操作
        adminService.add(admin, operationLog);
        System.out.println(admin);

        System.out.println(operationLog);
        return "redirect:admin.findAll";


    }

    @RequestMapping("/admin/admin.toupdate")
    public String toupdate(int id, ModelMap map) {

        Admin admin1 = adminService.findById(id);
        map.addAttribute("admin1", admin1);
        return "update_admin.jsp";
    }

    @RequestMapping("/admin/admin.update")
    public String update(int id, String newpwd, int grade, int disabled, ModelMap map, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Admin Admin = (Admin) session.getAttribute("admin");
        Admin admin = adminService.findById(id);
//      保存更新前的数据到 操作数据表
        OperationData operationData = new OperationData();
        operationData.setUuid(UUIDUtil.getUUID());
        operationData.setAdminId(admin.getId());
        operationData.setAdminAname(admin.getAname());
        operationData.setAdminApwd(admin.getApwd());
        operationData.setAdminDisabled(admin.getDisabled());
        operationData.setAdminGrade(admin.getGrade());

        //     添加更新日志 到 操作日志表
        OperationLog operationLog = new OperationLog();
        operationLog.setOperator(Admin.getAname());
        operationLog.setObject(admin.getAname());
        operationLog.setType("修改管理员");
        operationLog.setContent("对管理员" + admin.getAname() + "进行了修改");
        operationLog.setIp(IpUtil.getIpAddress(request));
        operationLog.setUuid(operationData.getUuid());

//      拿到前台要更新的数据
        admin.setApwd(newpwd);
        admin.setGrade(grade);
        admin.setDisabled(disabled);
        adminService.update(admin, operationLog, operationData);

        return "redirect:admin.findAll";
    }

    @RequestMapping("/admin/admin.updatePerson")
    public String updatePerson(int id, String newpwd, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = adminService.findById(id);
        admin.setApwd(newpwd);
        adminService.update(admin);
        session.removeAttribute("admin");
        return "redirect:/adminLogin";

    }

    @ResponseBody
    @RequestMapping("/admin/admin.findByAname")
    public String findByName(String aname) {

        Admin admin = adminService.findByAname(aname);

        if (admin != null) {
            return "fail";
        } else {
            return "success";
        }
    }

    @RequestMapping("/admin/admin.logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/adminLogin";
    }

    @RequestMapping("/admin/admin.lock")
    public String lock(String aname, HttpServletRequest request, ModelMap map) {

        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        map.addAttribute("aname", aname);
        return "lock.jsp";

    }

    @RequestMapping("/admin/admin.unlock")
    public String unlock(String aname,String apwd, HttpServletRequest request, ModelMap map) {

        HttpSession session = request.getSession();
        Admin admin = adminService.login(aname, apwd,request);
        if (admin != null) {

            session.setAttribute("admin", admin);
            return "redirect:index.jsp";
        } else {
            map.addAttribute("msg", "解锁失败");
            map.addAttribute("aname", aname);
            return "lock.jsp";
        }
    }


}
