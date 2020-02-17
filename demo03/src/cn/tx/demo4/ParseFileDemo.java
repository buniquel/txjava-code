package cn.tx.demo4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFileDemo {

    static List<Student> sList = new ArrayList<>();


    public static void main(String[] args) {
        parseFile();
    }

    public static void parseFile(){
        //java BIO
        BufferedReader br = null;
        //默认情况下文件的相对路径是工程路径
        try {
            br = new BufferedReader(new FileReader(new File("student.txt")));
            String line = null;
            while ((line = br.readLine()) != null){
                //把每一行数据用空格切分成数组
                //[学号, 27s1, 36s2, 151s1, 26s2, 13s3, 1245]
                //[姓名, 李四, 张三,   李玲,  王五, 李强 ,  亮哥]
                String[] data = line.split(" ");
                //获得头信息
                String head = data[0];
                if("学号".equals(head)){
                    //从索引1开始比那里，根据学号来创建学生对象
                    for (int i = 1; i < data.length; i++) {
                        //创建学生对象
                        Student s = new Student();
                        //给学生设置学号
                        s.setsNo(data[i]);
                        //把学生对象加入集合
                        sList.add(s);
                    }
                }
                if("姓名".equals(head)){
                    for (int i = 1; i < data.length; i++) {
                        //获得姓名
                        String name = data[i];
                        //获得这个姓名在对应的集合中的对象
                        Student s = sList.get(i - 1);
                        //设置姓名
                        s.setName(name);
                    }
                }

                if("性别".equals(head)){
                    for (int i = 1; i < data.length; i++) {
                        //获得这个姓名在对应的集合中的对象
                        Student s = sList.get(i - 1);
                        //设置姓名
                        s.setGender(data[i]);
                    }
                }

                if("年龄".equals(head)){
                    for (int i = 1; i < data.length; i++) {
                        //获得这个姓名在对应的集合中的对象
                        Student s = sList.get(i - 1);
                        //设置姓名
                        s.setAge(data[i]);
                    }
                }

                if("身高".equals(head)){
                    for (int i = 1; i < data.length; i++) {
                        //获得这个姓名在对应的集合中的对象
                        Student s = sList.get(i - 1);
                        //设置姓名
                        s.setTall(data[i]);
                    }
                }

                if("体重".equals(head)){
                    for (int i = 1; i < data.length; i++) {
                        //获得这个姓名在对应的集合中的对象
                        Student s = sList.get(i - 1);
                        //设置姓名
                        s.setWeight(data[i]);
                    }
                }

                if("电话".equals(head)){
                    for (int i = 1; i < data.length; i++) {
                        //获得这个姓名在对应的集合中的对象
                        Student s = sList.get(i - 1);
                        //设置姓名
                        s.setTel(data[i]);
                    }
                }
            }

            System.out.println(sList);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
