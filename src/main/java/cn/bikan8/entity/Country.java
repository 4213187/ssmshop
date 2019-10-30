package cn.bikan8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Integer id;
    private String name;
    private String countryId;
    private String cityId;
}
