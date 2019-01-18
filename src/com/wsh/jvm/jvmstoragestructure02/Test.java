package com.wsh.jvm.jvmstoragestructure02;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/18 17:26
 */
public class Test {
    static String str1 = new String("123");
    static String str2 = new String("123");

    static String str3 = "123";
    static String str4 = "123";

    public static void main(String[] args) {

        String str5 = "123";
        String str6 = "123";

        /**
         * str1/str2都是String对象的引用，分别持有指向堆中new String("123")出来的对象的地址，但是两次new String("123")的地址不一样，所以str1 == str2为false
         */
        //false
        System.out.println("str1 == str2   :-->" + (str1 == str2));

        /**
         * str3/str4都直接指向方法区中常量池中的"123"这个常量的地址，地址指向都相同，所以str3 == str4为true.
         */
        //true
        System.out.println("str3 == str4   :-->" + (str3 == str4));

        /**
         * 原理类似str3/str4
         */
        //true
        System.out.println("str5 == str6   :-->" + (str5 == str6));
    }

}
