package cn.tx.demo;

public class Demo11 {


    public static void main(String[] args) {
        //System.out.println(method());
        //divide(10,0);
        //System.out.println(method1());

        method4();
    }

    public static boolean method() {
        try {
            //方法遇到return， 给方法形成返回值
            return true;
            //.....
        } finally {
            //第二个return在finally中可以覆盖之前的return的方法返回值
            return false;
        }
    }


    public static void divide(int a, int b) {
        //....前面有一些资源开启 Connection， Reader， Writer
        try {
            int c = a / b;
            System.out.println("后续代码");
            //.....
        } finally {
            //来释放资源
            System.out.println("finally执行");
        }
    }


    public static int method1() {
        int c = 0;
        try {
            try {
                //报异常
                int i = 10 / 0;
                c = 3;
                return c;
            } catch (Exception e) {
                c = 4;
                //程序如果遇到了return，方法的返回值就会形成， 后续再怎么修改返回的变量c，都不会改变返回值
                return c;
            } finally {
                c = 5;
                return c;
            }
        } finally {
            c = 6;
            return c;
        }
    }


    public static void method2(){
        try {
            return;
        } finally {
            System.out.println("1");
        }
    }

    public static int method3(){
        try {
            return 1;
        } finally {
            System.out.println("1");
        }
    }



    public static void method4(){
        try {
            System.exit(-1);
            //finally是除了jvm的退出以外的任何情况都是要执行的。
        } finally {
            System.out.println("1");
        }
    }
}
