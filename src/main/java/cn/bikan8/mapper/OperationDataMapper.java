package cn.bikan8.mapper;


import cn.bikan8.entity.OperationData;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDataMapper {
   void add(OperationData operationData);
   OperationData findByUUID(String uuid);
}
