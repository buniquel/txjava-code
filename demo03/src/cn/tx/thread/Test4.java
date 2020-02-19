package cn.tx.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test4 {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();


    static class Task implements Runnable {
        Lock lock1;
        Lock lock2;

        public Task(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {

            try {
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"执行逻辑...");
                TimeUnit.MILLISECONDS.sleep(100);
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Task t = new Task(lock1, lock2);
        Task t1 = new Task(lock2, lock1);

        Thread thread = new Thread(t);
        Thread thread1 = new Thread(t1);
        thread.start();
        thread1.start();
        thread.interrupt();
    }

}
