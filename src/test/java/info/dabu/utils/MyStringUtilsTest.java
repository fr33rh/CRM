package info.dabu.utils;

import org.junit.Test;

/**
 * Created by AlexY on 2016/8/22.
 */
public class MyStringUtilsTest {
    @Test
    public void getMD5Value() throws Exception {


        String result  =  MyStringUtils.getMD5Value("jack1234");

        System.out.println(result);




    }

}