package cn.tx.demo5;

import java.util.List;

public class Test {


    public static void main(String[] args) {

        Pokers p = new Pokers(2.0, "姚记");
        List<Poker> list = p.getPokers();
        System.out.println(list);

        /*System.out.println("----------------洗牌----------------");
        p.shufflePoker();
        System.out.println(list);*/
        System.out.println("----------------随机抽取一张牌----------------");
        Poker poker = p.getRandomPoker();
        System.out.println(poker);
    }
}
