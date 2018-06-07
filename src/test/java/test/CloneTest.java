package test;

import java.io.*;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 11:30 2018/4/18
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Students students = new Students();
        Teather teather =new Teather();
        teather.setName("zhaona");
        students.setName("weidongdong");
        students.setAge("sss");
        students.setTeather(teather);
        //Students students1 = (Students) students.clone();
        Students students1 = (Students) students.deepClone();
        students1.getTeather().setName("don't know");
        System.out.println(students.getTeather().getName());
        System.out.println(students1.getTeather()==teather);
        System.gc();
    }

    static class Students implements Cloneable, Serializable {

        private String name;
        private String age;
        private Teather teather;

        public Teather getTeather() {
            return teather;
        }

        public void setTeather(Teather teather) {
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

    static class Teather implements Serializable {
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
}
