package com.cks.netty.bye.serializable;

import java.io.*;

/**
 * @Author: cks
 * @Date: Created by 2019/7/26 9:34
 * @Package: com.cks.netty.bye.serializable
 * @Description:
 */
public class TestSerializable {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("cks");
        person.setAge(20);

        // 把对象写到文件中
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("demo"))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从文件中读出对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("demo")))) {
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
