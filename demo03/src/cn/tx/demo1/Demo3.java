package cn.tx.demo1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
    应届生校招：上机题
        写程序获取一百个不重复的随机数。

    分析：1. 获得随机数
         2. 100个
         3  不能重复

        重复性：想到集合中的set， set是一个集合，里面可以存储元素，元素不重复，无序
 */
public class Demo3 {

    public static void main(String[] args) {
        //1. 获得随机数
        Random r = new Random();

        //创建一个set集合, 对于泛型不支持基本数据类型，
        // 但是在jdk1.5以后基本数据类型都有对于的包装类，我们可以使用包装类通过自动的装箱和拆箱来处理
        Set<Integer> set = new HashSet();
        //2. 100个   for(表达式1；表达式2；表达式3）
        for (;set.size() != 100;) {
            // 0(包括）~1000（不包括）   0-999
            int num = r.nextInt(1000);
            //把num加入集合
            set.add(num);
        }
        System.out.println(set);
        //输出集合的元素个数
        System.out.println("集合中的元素数量："+set.size());
    }
}
