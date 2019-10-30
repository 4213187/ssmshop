package cn.bikan8.service.impl;


import cn.bikan8.entity.City;
import cn.bikan8.entity.Country;
import cn.bikan8.entity.Province;
import cn.bikan8.mapper.AddrMapper;
import cn.bikan8.service.AddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrServiceImpl implements AddrService {
    @Autowired
    AddrMapper addrMapper;
    public AddrServiceImpl(AddrMapper addrMapper){
        this.addrMapper =addrMapper;
    }
    @Override
    public List<Province> findAllProvince() {
        return addrMapper.findAllProvince();
    }

    @Override
    public List<City> findByProvince(String provinceId) {
        return addrMapper.findByProvince(provinceId);
    }

    @Override
    public List<Country> findByCity(String cityId) {
        return addrMapper.findByCity(cityId);
    }
}
