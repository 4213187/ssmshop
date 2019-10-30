package cn.bikan8.service.impl;


import cn.bikan8.entity.OperationData;
import cn.bikan8.mapper.OperationDataMapper;
import cn.bikan8.service.OperationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationDataServiceImpl implements OperationDataService {
    @Autowired
    OperationDataMapper operationDataMapper;
    public  OperationDataServiceImpl(){

    }
    public  OperationDataServiceImpl(OperationDataMapper operationDataMapper){
         this.operationDataMapper =operationDataMapper;
    }
    @Override
    public void add(OperationData operationData) {
       operationDataMapper.add(operationData);

    }

    @Override
    public OperationData findByUUID(String uuid) {
        return operationDataMapper.findByUUID(uuid);
    }
}
