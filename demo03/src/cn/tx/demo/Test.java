package cn.tx.demo;

public class Test {

    public static void main(String[] args) {
        int value = getValue(2);
        System.out.println(value);
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
                break;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

}
