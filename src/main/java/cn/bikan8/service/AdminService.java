package cn.bikan8.service;


import cn.bikan8.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lenovo
 */
public interface AdminService {
    /**
     * 校验管理员账号密码是否正确
     * @param aname 管理员账号
     * @param apwd  管理员密码
     * @param request 封装登陆日志 ip属性需要用到
     * @return 管理员
     */
    Admin login(String aname, String apwd, HttpServletRequest request);

    /**
     * 通过级别查询小于该级别的所有的管理员
     * @param grade 管理员级别
     * @return 管理员集合
     */
    List<Admin> findAll(int grade);


    void delete(int id);

    void add(Admin admin);
    Admin findById(int id);
    void update(Admin admin);
    Admin findByAname(String aname);
}
