package cn.bikan8.service.impl;


import cn.bikan8.entity.OperationLog;
import cn.bikan8.mapper.OperationLogMapper;
import cn.bikan8.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperationLogMapper operationLogMapper;
    public OperationLogServiceImpl(){}
    public OperationLogServiceImpl(OperationLogMapper operationLogMapper){
        this.operationLogMapper =operationLogMapper;
    }

    @Override
    public List<OperationLog> findAll() {
        return operationLogMapper.findAll();
    }

    @Override
    public void add(OperationLog operationLog) {
        operationLogMapper.add(operationLog);

    }

    @Override
    public OperationLog findByUUID(String uuid) {
        return operationLogMapper.findByUUID(uuid);
    }

    @Override
    public void update(OperationLog operationLog) {
        operationLogMapper.update(operationLog);

    }
}
