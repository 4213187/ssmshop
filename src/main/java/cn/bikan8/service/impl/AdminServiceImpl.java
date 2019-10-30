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
    public void add(Admin admin, OperationLog operationLog) {

        operationLogMapper.add(operationLog);
        adminMapper.add(admin);

    }

    @Override
    public Admin findById(int id) {
        return adminMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(Admin admin, OperationLog operationLog ,OperationData operationData ) {
        operationDataMapper.add(operationData);
        adminMapper.update(admin);
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
    public void delete(int id, OperationData operationData, OperationLog operationLog) {
        operationDataMapper.add(operationData);
        adminMapper.delete(id);
        operationLogMapper.add(operationLog);
    }



}
