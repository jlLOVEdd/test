package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:56 2018/4/17
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String,Object> msp = new HashMap<String,Object>();
        msp.put("1111","1231");
        msp.put("1112","1231");
        msp.put("1113","1231");
        msp.put("1114","1231");
        msp.put("1115","1231");
        msp.put("1116","1231");
        msp.put("1117","1231");
        msp.put("1118","1231");
        msp.put("1119","1231");
        msp.put("1120","1231");
        msp.put("1121","1231");
        msp.put("1122","1231");
        msp.put("1123","1231");
        msp.put("1124","1231");
        msp.put("1125","1231");
        msp.put("1126","1231");

        System.out.println(msp.get("1111"));
    }
}
