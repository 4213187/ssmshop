package cn.bikan8.service.impl;



import cn.bikan8.entity.AdminLog;
import cn.bikan8.mapper.AdminLogMapper;
import cn.bikan8.service.AdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminLogServiceImpl implements AdminLogService {
    @Autowired
    AdminLogMapper adminLogMapper;

    public AdminLogServiceImpl() {

    }

    public AdminLogServiceImpl(AdminLogMapper adminLogMapper) {
        this.adminLogMapper = adminLogMapper;
    }

    @Override
    public void add(AdminLog adminLog) {

        adminLogMapper.add(adminLog);

    }

    @Override
    public List<AdminLog> findAll() {
        return adminLogMapper.findAll();
    }

    @Override
    public List<AdminLog> findByAname(String aname) {
        return adminLogMapper.findByAname(aname);
    }
}
