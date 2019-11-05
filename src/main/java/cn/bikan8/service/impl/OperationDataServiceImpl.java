package cn.bikan8.service.impl;


import cn.bikan8.entity.Admin;
import cn.bikan8.entity.OperationData;

import cn.bikan8.entity.OperationLog;
import cn.bikan8.mapper.AdminMapper;
import cn.bikan8.mapper.OperationDataMapper;
import cn.bikan8.mapper.OperationLogMapper;
import cn.bikan8.service.OperationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 小浩
 */
@Service
public class OperationDataServiceImpl implements OperationDataService {
    @Autowired
    OperationDataMapper operationDataMapper;
    @Autowired
    OperationLogMapper operationLogMapper;
    @Autowired
    AdminMapper adminMapper;
    public  OperationDataServiceImpl(){

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void rollbackFor(String uuid) {
        OperationLog operationLog = operationLogMapper.findByUUID(uuid);
//           如果是增加操作直接删除对应管理员即可
        if ("增加管理员".equals(operationLog.getType())){
            Admin afteradmin = adminMapper.findByAname(operationLog.getObject());
            adminMapper.delete(afteradmin.getId());

//          如果是删除或者修改操作回滚
        }else if("修改管理员".equals(operationLog.getType())){
            OperationData operationData = operationDataMapper.findByUUID(uuid);
            Admin beforeadmin =new Admin();
            beforeadmin.setId(operationData.getAdminId());
            beforeadmin.setAname(operationData.getAdminAname());
            beforeadmin.setApwd(operationData.getAdminApwd());
            beforeadmin.setDisabled(operationData.getAdminDisabled());
            beforeadmin.setGrade(operationData.getAdminGrade());
            adminMapper.update(beforeadmin);


        }else if ("删除管理员".equals(operationLog.getType())){
            OperationData operationData = operationDataMapper.findByUUID(uuid);
            Admin beforeadmin =new Admin();
            beforeadmin.setId(operationData.getAdminId());
            beforeadmin.setAname(operationData.getAdminAname());
            beforeadmin.setApwd(operationData.getAdminApwd());
            beforeadmin.setDisabled(operationData.getAdminDisabled());
            beforeadmin.setGrade(operationData.getAdminGrade());
            adminMapper.add(beforeadmin);
        }
        operationLogMapper.update(operationLog);

    }

    @Override
    public OperationData findByUUID(String uuid) {
        return operationDataMapper.findByUUID(uuid);
    }
}
