package cn.bikan8.util;

import java.util.Random;

public class RandomCodeUtil {
    private RandomCodeUtil(){

    }
    //生成随机数字和字母,
    public static String getSixRandomCode() {

        String val = "";
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < 6; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

//    public static void main(String[] args) {
//        System.out.println( RandomCodeUtil.getSixRandomCode());
//    }
}
