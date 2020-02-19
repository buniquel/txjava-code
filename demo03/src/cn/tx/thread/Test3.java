package cn.tx.thread;

public class Test3 {


    static Object lock1 = new Object();
    static Object lock2 = new Object();
    static int flag = 1;

    static class TxTask implements Runnable {

        int flag;

        public TxTask(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag == 1) {
                synchronized (lock1) {
                    System.out.println("进入锁1");
                    synchronized (lock2) {
                        System.out.println("进入锁1中的锁2");
                    }
                }
            } else {
                synchronized (lock2) {
                    System.out.println("进入锁2");
                    synchronized (lock1) {
                        System.out.println("进入锁2中的锁1");
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        TxTask task = new TxTask(1);
        TxTask task1 = new TxTask(0);
        Thread t = new Thread(task);
        Thread t1 = new Thread(task1);

        t.start();
        t1.start();
        t.interrupt();
    }

}
