package cn.tx.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo6 {

    public static void main(String[] args) {
        //定义一个数组，长度 5
        int[] arr = {12, 43, 56, 342, 546};

        Scanner s = new Scanner(System.in);
        //定义一个集合
        List<Integer> list = new ArrayList<>();
        //12 45 66 67 788
        String line = s.nextLine();
        //获得没一个数
        String[] data = line.split(" ");
        for (String d : data) {
            list.add(new Integer(d));
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
