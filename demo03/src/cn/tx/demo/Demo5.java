package cn.tx.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo5 {

    public static void main(String[] args) {
        //定义一个数组，长度 5
        int[] arr = {12, 43, 56, 342, 546};

        Scanner s = new Scanner(System.in);
        //定义一个集合
        List<Integer> list = new ArrayList<>();
        while (true){
            //输入一个数
            int num = s.nextInt();
            if(num <= 0){
                System.out.println("输入结束");
                break;
            }
            //把这个数加入集合
            list.add(num);
        }
        System.out.println("新输入的集合："+list);
        List<Integer> list1 = getArr(arr, list);
        //排序
        Collections.sort(list1);
        System.out.println("合并后的集合："+list1);
    }

    /**
     * 获得新的数组
     */
    public static List<Integer> getArr(int[] oldArr, List<Integer> list) {
        for (int i : oldArr) {
            list.add(i);
        }
        return list;
    }
}
