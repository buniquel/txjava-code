package cn.tx.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo4 {

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
        System.out.println(list);

        //数组的长度是不可变吗，肯定不能插入数的
        //我们的思路是新创建一个数组，包含老数组的内容和输入的这个数，并且按着源数组的顺序排序
        int[] newArr = getArr(arr, list);
        sort(newArr);
        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 获得新的数组
     */
    public static int[] getArr(int[] oldArr, List<Integer> list) {
        //获得集合中的元素的个数
        int size = list.size();
        //定义一个数组
        int[] listArr = new int[size];
        //把集合中的每一个元素都放入数组中
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            listArr[i] = integer;
        }

        //创建新的数组
        int[] newArr = new int[oldArr.length + size];
        //把老数组中的数拷贝到新数组
        /**
            src: 源数组
            srcPos: 源数组的拷贝的开始索引
            dest：目标数组
            destPos: 目标数组的索引
            length: 拷贝和粘贴的长度

         */
        System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
        //把list转换成的数组拷贝到新的数组中
        System.arraycopy(listArr, 0, newArr,  oldArr.length , size);
        return newArr;
    }
    /**
     * 冒泡排序
     * @param arr
     */
    public static void sort(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
