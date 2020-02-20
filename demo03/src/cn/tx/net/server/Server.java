package cn.tx.net.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {


    public static void main(String[] args) {

        //数据接收

        //创建服务套接字
        DatagramSocket ds = null;

        try {
            ds = new DatagramSocket(10000);
            //创建一个接收的字节数组
            byte[] bs = new byte[1024];
            //创建一个空的数据包
            DatagramPacket dp = new DatagramPacket(bs, bs.length);
            //接收数据
            ds.receive(dp);

            //获得数据包的长度
            int length = dp.getLength();
            //把字节数组转换成字符串
            String s = new String(bs, 0, length);
            System.out.println("接收到的数据是："+s);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ds != null){
                ds.close();
            }
        }


    }
}
