package cn.tx.demo4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseFileDemo2 {

    static List<Student> sList = new ArrayList<>();


    public static void main(String[] args) {
        parseFile();
        printFile();
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

                for (int i = 1; i < data.length; i++) {
                    if ("学号".equals(head)) {
                        //从索引1开始比那里，根据学号来创建学生对象

                        //创建学生对象
                        Student s = new Student();
                        //给学生设置学号
                        s.setsNo(data[i]);
                        //把学生对象加入集合
                        sList.add(s);
                    }
                    Student s = sList.get(i - 1);
                    switch (head){
                        case "姓名":
                            s.setName(data[i]);
                            break;
                        case "性别":
                            s.setGender(data[i]);
                            break;
                        case "年龄":
                            s.setAge(data[i]);
                            break;
                        case "身高":
                            s.setTall(data[i]);
                            break;
                        case "体重":
                            s.setWeight(data[i]);
                            break;
                        case "电话":
                            s.setTel(data[i]);
                            break;
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

    public static void printFile(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("result.txt");
            pw.println("学号\t姓名\t性别\t年龄\t身高\t体重\t电话");
            for (Student s : sList) {
                pw.println(s.getsNo()+"\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getAge()+"\t"+s.getTall()+"\t"+s.getWeight()+"\t"+s.getTel());
            }
            pw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(pw != null){
                pw.close();
            }
        }
    }
}
