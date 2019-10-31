package cn.bikan8.service.impl;


import cn.bikan8.entity.Admin;
import cn.bikan8.entity.AdminLog;
import cn.bikan8.entity.OperationData;
import cn.bikan8.entity.OperationLog;
import cn.bikan8.mapper.AdminLogMapper;
import cn.bikan8.mapper.AdminMapper;
import cn.bikan8.mapper.OperationDataMapper;
import cn.bikan8.mapper.OperationLogMapper;
import cn.bikan8.service.AdminService;
import cn.bikan8.util.IpUtil;
import cn.bikan8.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lenovo
 */
@Service

public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AdminLogMapper adminLogMapper;
    @Autowired
    OperationLogMapper operationLogMapper;
    @Autowired
    OperationDataMapper operationDataMapper;

    public AdminServiceImpl() {

    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Admin login(String aname, String apwd, HttpServletRequest request) {

        Admin admin = adminMapper.find(aname, apwd);
        if (admin != null) {
            AdminLog adminLog = new AdminLog();
            adminLog.setAname(admin.getAname());
            String ipAddress = IpUtil.getIpAddress(request);
            adminLog.setIp(ipAddress);
            adminLogMapper.add(adminLog);
            return admin;
        }
        return null;

    }

    @Override
    public List<Admin> findAll(int grade) {

        return adminMapper.findAll(grade);
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(Admin admin, Admin Admin,HttpServletRequest request) {
//          添加增加日志到日志表
        OperationLog operationLog = new OperationLog();
        operationLog.setUuid(UUIDUtil.getUUID());
        operationLog.setType("增加管理员");
        operationLog.setContent("增加了一个账号为:" + admin.getAname() + "的管理员");
        operationLog.setIp(IpUtil.getIpAddress(request));
        operationLog.setObject(admin.getAname());
        operationLog.setOperator(Admin.getAname());
        operationLogMapper.add(operationLog);
//      添加操作
        adminMapper.add(admin);

    }

    @Override
    public Admin findById(int id) {
        return adminMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(Admin beforeadmin,Admin afterAdmin, Admin Admin ,HttpServletRequest request ) {
//      保存更新前的数据到 操作数据表
        OperationData operationData = new OperationData();
        operationData.setUuid(UUIDUtil.getUUID());
        operationData.setAdminId(beforeadmin.getId());
        operationData.setAdminAname(beforeadmin.getAname());
        operationData.setAdminApwd(beforeadmin.getApwd());
        operationData.setAdminDisabled(beforeadmin.getDisabled());
        operationData.setAdminGrade(beforeadmin.getGrade());
        operationDataMapper.add(operationData);
//      更新管理员
        adminMapper.update(afterAdmin);
//     添加更新日志 到 操作日志表
        OperationLog operationLog = new OperationLog();
        operationLog.setOperator(Admin.getAname());
        operationLog.setObject(beforeadmin.getAname());
        operationLog.setType("修改管理员");
        operationLog.setContent("对管理员" + beforeadmin.getAname() + "进行了修改");
        operationLog.setIp(IpUtil.getIpAddress(request));
        operationLog.setUuid(operationData.getUuid());
        operationLogMapper.add(operationLog);

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(Admin admin) {

        adminMapper.update(admin);
    }

    @Override
    public Admin findByAname(String aname) {
        return adminMapper.findByAname(aname);
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete( HttpServletRequest request,Admin Admin, Admin admin) {
        //添加删除之前的数据保存到数据表
        OperationData operationData = new OperationData();
        operationData.setUuid(UUIDUtil.getUUID());
        operationData.setAdminId(admin.getId());
        operationData.setAdminAname(admin.getAname());
        operationData.setAdminApwd(admin.getApwd());
        operationData.setAdminDisabled(admin.getDisabled());
        operationData.setAdminGrade(admin.getGrade());
        operationDataMapper.add(operationData);
        //删除操作
        adminMapper.delete(admin.getId());
        //添加删除日志到日志表
        OperationLog operationLog = new OperationLog();
        operationLog.setUuid(operationData.getUuid());
        operationLog.setOperator(Admin.getAname());
        operationLog.setObject(admin.getAname());
        operationLog.setIp(IpUtil.getIpAddress(request));
        operationLog.setContent("删除了一个账号为:" + admin.getAname() + "的管理员");
        operationLog.setType("删除管理员");
        operationLogMapper.add(operationLog);


    }



}
