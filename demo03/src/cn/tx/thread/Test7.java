package cn.tx.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Test7 {

    static TxLock lock = new TxLock();

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
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"正在执行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class TxLock{

        ConcurrentLinkedQueue<Thread> threads = new ConcurrentLinkedQueue<>();
        /**
         *  0 表示没有获得锁
         *  1 拥有锁
         *
         */
        static final Unsafe unsafe;
        static final long stateOffset;
        volatile long status = 0;
        static {
            try {
                //使用反射获取Unsafe的成员变量theUnsafe
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                //设置为可存取
                field.setAccessible(true);
                //获取该变量的值
                unsafe = (Unsafe) field.get(null);
                //获取state在TestUnSafe中的汇编语言偏移量
                stateOffset = unsafe.objectFieldOffset(TxLock.class.getDeclaredField("status"));
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
                throw new Error(ex);
            }
        }


        /**
         * CAS
         *
         */
        public void lock(){
            //想要把status改成1
            while (!unsafe.compareAndSwapInt(status, stateOffset, 0, 1)){
                threads.offer(Thread.currentThread());
                LockSupport.park();
            }
        }

        public void unlock(){
            //想要把status改成0
            while (unsafe.compareAndSwapInt(status, stateOffset, 1, 0)){
                Thread thread = threads.poll();
                LockSupport.unpark(thread);
            }
        }


    }
}
