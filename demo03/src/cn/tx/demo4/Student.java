package cn.tx.demo4;

public class Student {

    private String sNo;
    private String name;
    private String gender;
    private String age;
    private String tall;
    private String weight;
    private String tel;

    public Student() {
    }

    public Student(String sNo, String name, String gender, String age, String tall, String weight, String tel) {
        this.sNo = sNo;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tall = tall;
        this.weight = weight;
        this.tel = tel;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTall() {
        return tall;
    }

    public void setTall(String tall) {
        this.tall = tall;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo='" + sNo + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", tall='" + tall + '\'' +
                ", weight='" + weight + '\'' +
                ", tel='" + tel + '\'' +
                '}'+"\n";
    }
}
