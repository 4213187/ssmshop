package cn.bikan8.mapper;

import cn.bikan8.entity.City;
import cn.bikan8.entity.Country;
import cn.bikan8.entity.Province;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface AddrMapper {
    List<Province> findAllProvince();
    List<City> findByProvince(String provinceId);
    List<Country> findByCity(String cityId);
}
