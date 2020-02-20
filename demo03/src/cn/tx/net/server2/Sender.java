package cn.tx.net.server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender extends Thread{


    public void run() {


        //java里面服务的套接字
        DatagramSocket ds = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            //创建套接字对象, 网络资源的连接，使用完毕要关掉
            ds = new DatagramSocket();
            while (true){
                //定义一句话, UTF-8编码，汉字3个字节表示
                String str = br.readLine();
                //把字符串变成字节 数组
                byte[] bs = str.getBytes();
                //创建UDP的数据包
            /*
                第一个参数：要发送的数据的字节数组
                第二个参数：发送数据的长度
                第三个参数：服务端的ip
                第四个参数：服务器端的端口
             */
                DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("127.0.0.1"), 10001);
                ds.send(dp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ds != null){
                    ds.close();
                }
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}
