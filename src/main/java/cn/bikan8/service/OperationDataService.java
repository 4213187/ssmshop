package cn.bikan8.service;


import cn.bikan8.entity.OperationData;

public interface OperationDataService {
    void add(OperationData operationData);
    OperationData findByUUID(String uuid);
}
