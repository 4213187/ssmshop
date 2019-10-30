package cn.bikan8.service;


import cn.bikan8.entity.AdminLog;

import java.util.List;

public interface AdminLogService {
    void add(AdminLog adminLog);
    List<AdminLog> findAll();
    List<AdminLog> findByAname(String aname);
}
