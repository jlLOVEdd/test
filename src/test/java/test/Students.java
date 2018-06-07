package test;

import java.io.*;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 11:40 2018/4/18
 */
public class Students implements Cloneable, Serializable {

    private String name;
    private String age;
    private CloneTest.Teather teather;

    public CloneTest.Teather getTeather() {
        return teather;
    }

    public void setTeather(CloneTest.Teather teather) {
        this.teather = teather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws IOException, ClassNotFoundException {



        /* 写入当前对象的二进制流 */

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);



        /* 读出二进制流产生的新对象 */

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();

    }
}

