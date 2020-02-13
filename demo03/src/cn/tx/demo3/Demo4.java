package cn.tx.demo3;

public class Demo4 {

    public static void main(String[] args) {

        //String字符串是不可变
        StringBuffer str = new StringBuffer("aa.bb.cc");
        str.delete(2,6);
        //str.substring(2, 6);
        System.out.println(str);
    }
}
