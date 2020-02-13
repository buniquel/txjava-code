package cn.tx.demo3;



public class Test {

    /*
        执行时机：jvm加载当前的class文件的时候就执行
     */
    static{
        System.out.println("A");
    }

    /*
        执行时机： jvm加载当前的class文件的时候就执行， 多个static出现时候按着从上到下的顺序加载
     */
    static Test t = new Test();



    /*
        执行时机：创建对象的时候（）
     */
    {
        System.out.println("B");
    }
    public static void main(String[] args) {
        new Test();
    }

}
