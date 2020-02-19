package cn.tx.thread;

import java.util.concurrent.TimeUnit;

public class Test1 {


    public static void main(String[] args) {
        Task t = new Task();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
    }

    static class Task implements Runnable{

        @Override
        public void run() {

            synchronized (this){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在执行...");
            }

        }
    }
}
