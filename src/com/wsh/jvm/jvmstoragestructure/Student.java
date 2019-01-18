package com.wsh.jvm.jvmstoragestructure;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/18 16:46
 */
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public void sayHello() {
        System.out.println("hello..." + name + "-->" + age);
    }
}
