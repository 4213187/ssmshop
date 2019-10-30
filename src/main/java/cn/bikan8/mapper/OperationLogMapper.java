package cn.bikan8.mapper;


import cn.bikan8.entity.OperationLog;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OperationLogMapper {
    List<OperationLog> findAll();
    void add(OperationLog operationLog);
    OperationLog findByUUID(String uuid);
    void update(OperationLog operationLog);
}
