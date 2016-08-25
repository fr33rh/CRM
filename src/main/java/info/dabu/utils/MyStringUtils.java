package info.dabu.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by AlexY on 2016/8/22.
 */
public class MyStringUtils {


    /**
     * 获得md5加密后的数据
     *
     * @param value 明文
     * @return 密文
     */
    public static String getMD5Value(String value) {


        try {
            //1 获得jdk提供消息摘要算法工具类
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            //2 加密的结果10进制
            byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());

            //3将10进制 转换16进制 , 1表示返回整数，0返回0，-1返回负数
            BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);

            System.out.println(Arrays.toString(md5ValueByteArray));
            return bigInteger.toString(16);



        } catch (Exception e) {

            throw  new RuntimeException(e);
        }


    }




    /**
     * 获得一个32长度的UUID值
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }






}
