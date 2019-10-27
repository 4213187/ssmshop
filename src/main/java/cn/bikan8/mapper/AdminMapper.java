package cn.bikan8.mapper;


import cn.bikan8.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lenovo
 */
public interface AdminMapper {
    /**
     * 通过等级查询所有的管理员
     * @param grade
     * @return 所有的管理员
     */
    List<Admin> findAll(int grade);

}