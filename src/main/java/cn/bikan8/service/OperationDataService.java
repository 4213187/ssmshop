package cn.bikan8.service;


import cn.bikan8.entity.OperationData;

public interface OperationDataService {
    void rollbackFor(String uuid);
    OperationData findByUUID(String uuid);
}
