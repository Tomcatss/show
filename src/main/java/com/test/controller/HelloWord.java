package com.test.controller;

public class HelloWord {

    public String hello(){//在controller下的testHello里面调用此方法进行测试
        System.out.println("hello word");
        return "success";
    }
//main()方法不需要在这里写，而是在test.java.com.test.controller下面写一个测试类进行测试结果是否正确
//    public static void main(String[] args) {
//        HelloWord helloWord = new HelloWord();
//        helloWord.hello();
//    }
}
