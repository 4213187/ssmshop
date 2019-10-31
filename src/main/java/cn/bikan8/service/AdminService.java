package cn.bikan8.service;


import cn.bikan8.entity.Admin;
import cn.bikan8.entity.OperationData;
import cn.bikan8.entity.OperationLog;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lenovo
 */
public interface AdminService {

    /**
     * 检验管理员账号密码是否正确
     * @param aname 管理员账号
     * @param apwd  管理员密码
     * @param request 日志ip需要从request获取
     * @return 管理员
     */
    Admin login(String aname, String apwd, HttpServletRequest request);

    /**
     * 通过等级查询所有下级
     * @param grade 等级
     * @return 管理员集合
     */
    List<Admin> findAll(int grade);

    /**
     * 添加管理员
     * @param admin 要添加的管理员
     * @param Admin 操作人员
     * @param request 日志ip需要从request获取
     */
    void add(Admin admin, Admin Admin,HttpServletRequest request);

    /**
     * 通过id查询对应的管理员
     * @param id 管理员的id
     * @return 管理员对象
     */
    Admin findById(int id);

    /**
     * 更新个人信息(管理员) 不会添加操作日志
     * @param admin
     */
    void update(Admin admin );

    /**
     * 通过账号查找管理员
     * @param aname
     * @return 管理员对象
     */
    Admin findByAname(String aname);

    /**
     * 删除管理员
     * @param request  日志ip需要从request获取
     * @param Admin 操作人员
     * @param admin 要删除的管理员
     */
    void delete(HttpServletRequest request, Admin Admin, Admin admin);

    /**
     * 更新管理员信息
     * @param beforeAdmin 更新前的管理员信息 要保存数据 可以回滚
     * @param afterAdmin  要更新的管理员
     * @param Admin  操作人员
     * @param request  日志ip需要从request获取
     */
    void update(Admin beforeAdmin,Admin afterAdmin,Admin Admin,HttpServletRequest request);
}
