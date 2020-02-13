package cn.tx.demo3;

public class Demo3 {

    public static void main(String[] args) {
        //String字符串是不可变
        String str = "aa.bb.cc";

        str = str.substring(2, 6);
        System.out.println(str);
    }
}
