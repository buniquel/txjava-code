package cn.tx.demo5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pokers {
    /*
    属性：张数、价格、品牌
	行为：创建、洗牌、随机抽取一张

     */

    private int count = 54;

    private double price;

    private String brand;

    /**
     * 创建一个复杂属性：里面存储的就是单张牌的对象
     */
    private List<Poker> pokers = new ArrayList<>();

    /*
        创建一副牌
     */
    public Pokers(double price, String brand) {
        this.price = price;
        this.brand = brand;
        /*
            创建54个单张牌对象
         */
        //外层是循环的花色值 i:花色值
        for (int i = 2; i <= 5; i++) {
            //每一种花色的点数 j：点数值
            for (int j = 1; j <= 13; j++) {
                //创建单张牌对象
                Poker p = new Poker();
                //设置花色值
                p.setColorValue(i);
                //设置这个花色值对应的花色符号
                setColor(p, i);
                //设置点数值
                p.setCardValue(j);
                //设置这个点数值对应的点数符号
                setCardNo(p, j);
                //把这个单张牌对象加入集合
                pokers.add(p);
            }
        }
        //创建小王String cardNo, int cardValue, String color, int colorValue
        Poker p = new Poker("小王", 14, "♛", 1);
        Poker p1 = new Poker("大王", 15, "♛", 1);
        pokers.add(p);
        pokers.add(p1);
    }

    /**
     * 根据花色值设置花色符号
     *
     * @param p
     * @param colorValue ♛  ♥ ♢  ♠  ♣
     */
    public void setColor(Poker p, int colorValue) {
        switch (colorValue) {
            case 1:
                p.setColor("♛");
                break;
            case 2:
                p.setColor("♥");
                break;
            case 3:
                p.setColor("♢");
                break;
            case 4:
                p.setColor("♠");
                break;
            case 5:
                p.setColor("♣");
                break;
        }
    }

    /**
     * /*
     * 点数:  A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J,   Q, K,  小王, 大王
     * 点数值：1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,  15
     *
     * @param p
     * @param cardValue
     */
    public void setCardNo(Poker p, int cardValue) {
        switch (cardValue) {
            case 1:
                p.setCardNo("A");
                break;
            case 11:
                p.setCardNo("J");
                break;
            case 12:
                p.setCardNo("Q");
                break;
            case 13:
                p.setCardNo("K");
                break;
            default:
                p.setCardNo(cardValue + "");
        }
    }

    /**
     * 洗牌
     *
     */
    public void shufflePoker() {
        //把集合打乱
        Collections.shuffle(pokers);
    }

    /**
     * 随机抽取一张牌
     * List<Poker> pokers = new ArrayList<>();
     * 索引：0 - 53
     * 如果我们能随机的获得一个索引号，那么就可以根据这个索引号获得这个对应的扑克牌对象
     *
     */
    public Poker getRandomPoker() {
        //创建一个随机数对象
        Random r = new Random();
        //获得 0- 53之间的随机的索引
        int index = r.nextInt(54);
        //蝴蝶对应的对象
        Poker poker = pokers.get(index);
        return poker;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    public void setPokers(List<Poker> pokers) {
        this.pokers = pokers;
    }
}
