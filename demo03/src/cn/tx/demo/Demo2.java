package cn.tx.demo;

import java.util.Date;

public class Demo2 {

    /**
        给定年月如：2020-1，计算这个月有多少天
        月份有多少种 天数

        31   1 3 5 7 8 10 12

        30   4 6 9 11

        28   2 平年

        29   2 闰年     能被400整除，或者能被4整除但是不能被100整除

     */
    public static int getMonthDay(int year, int month){
        int days = -1;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                //闰年的情况
                if(year % 400 == 0 ||(year % 4 ==0 && year % 100 != 0)){
                    days = 29;
                }else{
                    days = 28;
                }
        }
        return days;

    }


    /**
     * 给定年月日如： 2020-4-10 ，计算这天是这一年的第多少天呢？

        1   2   3   4

        31  29  31  10

        1.求出当前月之前的每一个月的整月天数之和
        2.加上当前的日期day

     */
    public static int getYearDays(int year, int month, int day){
        //定义总天数的变量
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += getMonthDay(year, i);
        }
        totalDays += day;
        return totalDays;
    }

    /**
        计算指定年月日是星期几 如: 2020-1-31 是星期几

        int week = (year-1+(year-1)/4-(year-1)/100+(year-1)/400+days)%7;
        已知条件：
            year,
            days(给定年月日如： 2020-4-10 ，计算这天是这一年的第多少天)
     */

    public static int getWeek(int year, int month, int day){
        //求出当前的年月日是这一年的第多少天
        int days = getYearDays(year, month, day);
        //套公式求出星期
        int week = (year-1+(year-1)/4-(year-1)/100+(year-1)/400+days)%7;
        return week;
    }

    /**
     * 打印日历
     */
    public static void printDate(int year, int month){
        System.out.println("\t\t<"+year+"年"+month+"月>");
        System.out.println();
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        System.out.println();
        //获得当前月的天数
        int monthDay = getMonthDay(year, month);
        //计算1号之前要打印几个空格就计算 这个2020-1-1是星期几就可以了
        int week = getWeek(year, month, 1);

        //定义一个计数器
        int count = 0;
        //打印日历
        //先打印空格
        for (int i = 0; i < week; i++) {
            System.out.print("\t");
            count++;
        }
        for (int i = 1; i <= monthDay ; i++) {
            Date d = new Date();
            int date = d.getDate();
            int mon = d.getMonth()+1;


            if( date == i && mon == month){
                System.out.print("("+i+")\t");
            }else{
                System.out.print(i+"\t");
            }


            count++;
            if(count % 7 == 0){
                System.out.println();
                System.out.println();
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        printDate(2020, 1);
        /*Date d = new Date();
        System.out.println(d.getMonth()+1);*/


    }
}
