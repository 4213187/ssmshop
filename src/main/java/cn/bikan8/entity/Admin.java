package cn.bikan8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private Integer id;
    private String aname;
    private  String apwd;
    private  Integer disabled;
    private  Integer grade;
}
