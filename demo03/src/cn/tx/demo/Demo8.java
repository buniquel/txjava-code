package cn.tx.demo;

/**
 * static关键字只有 三个地方能用
 */
public class Demo8 {

    /**
     *                  本类中     同包中     父子类关系       无关类
        public           √          √           √             √
        protected        √          √           √             ×
        默认（不写）       √          √           ×             ×
        private          √          ×           ×             ×

        权限修饰符是在类中（不是在接口中）
     */
    void func1() {
        int i = 1;
        if (i > 0)
            //在void方法中return是表示终止程序的意思
            return;
        System.out.println("程序继续执行");
    }

    /*

        short  ----> float
     */

    float func2(){
        short i=2;
        return i;
    }

    /*
          8字节       4个字节
          long --- > float
     */
    float func3(){
        long i=3;
        return i;
    }

    float func4(){
        double i=4;
        return (float) i;
    }








}
