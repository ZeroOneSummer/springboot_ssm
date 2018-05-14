package com.dfmall.lambda;

import java.util.Arrays;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.lambda
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年05月14日 20:09
 */
public class Test {
    public static void main(String[] args) {
        //常规匿名内部类创建线程
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run ...");
            }
        }).start();*/

        //lambda表达式（闭包/匿名函数）创建线程
      /* new Thread(() -> System.out.println("lambda"));*/

        //闭包遍历集合
       /* Arrays.asList("1","2","3","4","5").stream()
                .filter(v -> Integer.parseInt(v) > 3)
                .forEach(System.out::println);*/

        //闭包并行遍历集合
        Arrays.asList("1","2","3","4","5").parallelStream()
                .forEachOrdered(System.out::println);

    }
}
