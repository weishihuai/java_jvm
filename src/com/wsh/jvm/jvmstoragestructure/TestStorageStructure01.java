package com.wsh.jvm.jvmstoragestructure;

/**
 * @Description: 测试Java内存结构分析
 * @author: weishihuai
 * @Date: 2019/1/18 16:48
 */
public class TestStorageStructure01 {

    public static void main(String[] args) {

        /**
         * 1. Student经过类加载器的加载,Student类代码信息、静态变量信息等都存放在方法区中;
         * 2. student对象存放在栈中,是Student对象的引用,持有堆中new Student()对象的内存地址,通过这个地址可以找到堆中new出来的对象;
         * 3. new Student()出来的对象存放在堆中, 持有方法区中Student类信息的地址引用;
         */
        Student student = new Student("lisi", 20);

        /**
         * 1. 调用sayHello()方法时,会创建一个栈帧对象，存放着方法的参数、过程结果等数据;
         * 2. 通过栈中student对象持有的地址找到在堆中new出来的Student对象;
         * 3. 通过堆中持有的方法区中Student类的信息，找到sayHello()方法字节码，执行sayHello()方法，输出结果;
         * 4. 伴随着栈帧的出栈操作;
         */
        student.sayHello();
    }


}
