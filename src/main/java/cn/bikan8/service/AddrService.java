package cn.bikan8.service;



import cn.bikan8.entity.City;
import cn.bikan8.entity.Country;
import cn.bikan8.entity.Province;

import java.util.List;

public interface AddrService {
    List<Province> findAllProvince();
    List<City> findByProvince(String provinceId);
    List<Country> findByCity(String cityId);
}
