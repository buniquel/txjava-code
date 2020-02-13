package cn.tx.demo3;

public class Demo2 {


    public static void main(String[] args) {
        //jdk1.5以后提供的一个自动装箱
        Integer num1 = 100;
        Integer num2 = 100;
        System.out.println(num1 == num2);

        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println(num3 == num4);
    }
}
