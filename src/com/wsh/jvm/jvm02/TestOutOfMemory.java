package com.wsh.jvm.jvm02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 模拟内存溢出
 * @author: weishihuai
 * @Date: 2019/1/25 16:17
 */
public class TestOutOfMemory {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        while (true) {
            // -Xmx1024m:最大堆内存空间
            // -Xms1024m:初始堆内存大小
            // -XX:+HeapDumpOnOutOfMemoryError: 当堆抛出OOM错误时，dump出当前的内存堆转储快照
            // -XX:HeapDumpPath=d:\oom.hprof 该参数的含义是指定dump的文件目录，d:\oom.hprof
            // -XX:+PrintGCDetails: 打印垃圾收集的日志详细信息
            studentList.add(new Student());
        }
    }
}
