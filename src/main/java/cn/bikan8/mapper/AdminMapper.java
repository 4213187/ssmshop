package cn.bikan8.mapper;


import cn.bikan8.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    List<Admin> findAll(int grade);
    Admin find(@Param("aname") String aname, @Param("pwd") String apwd);
    Admin findById(int id);
    Admin findByAname(String aname);
    void delete(int id);
    void update(Admin admin);
    void add(Admin admin);
}
