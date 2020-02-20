package cn.tx.net.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {


    public static void main(String[] args) {


        //java里面服务的套接字
        DatagramSocket ds = null;

        try {
            //创建套接字对象, 网络资源的连接，使用完毕要关掉
            ds = new DatagramSocket();
            //定义一句话, UTF-8编码，汉字3个字节表示
            String str = "你好，拓薪教育";
            //把字符串变成字节 数组
            byte[] bs = str.getBytes();
            System.out.println("长度："+bs.length);
            //创建UDP的数据包
            /*
                第一个参数：要发送的数据的字节数组
                第二个参数：发送数据的长度
                第三个参数：服务端的ip
                第四个参数：服务器端的端口
             */
            DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("127.0.0.1"), 10000);
            ds.send(dp);
            System.out.println("发送完毕");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ds != null){
                ds.close();
            }
        }


    }



}
