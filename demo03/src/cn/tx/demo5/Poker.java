package cn.tx.demo5;

public class Poker {

    /*
        点数:  A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J,   Q, K,  小王, 大王
     */
    private String cardNo;
    /*
        点数值：1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,  15
     */
    private int cardValue;

    /*
	    花色：  ♛  ♥ ♢  ♠  ♣
     */
    private String color;
    /*
	    花色值： 1  2  3  4  5
     */
    private int colorValue;

    public Poker() {
    }

    public Poker(String cardNo, int cardValue, String color, int colorValue) {
        this.cardNo = cardNo;
        this.cardValue = cardValue;
        this.color = color;
        this.colorValue = colorValue;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColorValue() {
        return colorValue;
    }

    public void setColorValue(int colorValue) {
        this.colorValue = colorValue;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "cardNo='" + cardNo + '\'' +
                //", cardValue=" + cardValue +
                ", color='" + color + '\'' +
                //", colorValue=" + colorValue +
                '}'+"\n";
    }
}
