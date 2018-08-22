package com.test.controller;

import org.junit.Test;//对应@Test

import static org.junit.Assert.assertEquals;
//junit是一个测试类，在这里编写main.java.com.test.controller下的Java类的测试类@Test
public class HelloWordTest {

    @Test
    public void testHello(){//注意这里不是main()方法。可以直接右击运行HelloWordTest,就会运行此Test下的testHello()方法
        HelloWord helloWord = new HelloWord();//实例化一个HelloWord类
        String comment = helloWord.hello();
        assertEquals("success",comment);//"success"和return返回结果进行比较
    }
}
