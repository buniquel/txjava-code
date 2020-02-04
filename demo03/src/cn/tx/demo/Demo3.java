package cn.tx.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {
        //定义一个数组，长度 5
        int[] arr = {12, 43, 56, 342, 546};

        Scanner s = new Scanner(System.in);
        //输入一个数
        int num = s.nextInt();
        //数组的长度是不可变吗，肯定不能插入数的
        //我们的思路是新创建一个数组，包含老数组的内容和输入的这个数，并且按着源数组的顺序排序
        int[] newArr = getArr(arr, num);
        sort(newArr);
        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 获得新的数组
     */
    public static int[] getArr(int[] oldArr, int num) {
        //创建新的数组
        int[] newArr = new int[oldArr.length + 1];
        //把老数组中的数拷贝到新数组
        /*
            src: 源数组
            srcPos: 源数组的拷贝的开始索引
            dest：目标数组
            destPos: 目标数组的索引
            length: 拷贝和粘贴的长度

         */
        System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
        //把输入的这个数先放着最后一个位置
        newArr[oldArr.length] = num;
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
