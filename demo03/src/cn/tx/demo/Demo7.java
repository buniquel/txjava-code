package cn.tx.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo7 {

    public static void main(String[] args) {
        //定义一个数组，长度 5
        int[] arr = {12, 43, 56, 342, 546};
        //定义一个集合
        List<Integer> list = new ArrayList<>();
        for (String d : args) {
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
