package cn.tx.net.server2;

public class ChatRoom {


    public static void main(String[] args) {
        //创建两个线程
        Sender sender = new Sender();
        Server server = new Server();
        sender.start();
        server.start();
    }
}
