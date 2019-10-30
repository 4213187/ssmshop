package cn.bikan8.mapper;

import cn.bikan8.entity.AdminLog;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface AdminLogMapper {
    void add(AdminLog adminLog);
    List<AdminLog> findAll();
    List<AdminLog> findByAname(String aname);
}
