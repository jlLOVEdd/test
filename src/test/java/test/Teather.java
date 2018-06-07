package test;

import java.io.Serializable;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 11:40 2018/4/18
 */
public class Teather implements Serializable {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
