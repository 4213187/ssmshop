package cn.bikan8.util;

import java.util.UUID;

public class UUIDUtil {
    private  UUIDUtil(){}
    public  static  String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }
}
