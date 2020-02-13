package cn.tx.demo3;

public class Person {


    public Person(){
        System.out.println("构造器");
    }

    {
        System.out.println("对象代码块");
    }

    public static void main(String[] args) {
        new Person();
        new Person();
        new Person();
    }
}
