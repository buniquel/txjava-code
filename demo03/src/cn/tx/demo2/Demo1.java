package cn.tx.demo2;

public class Demo1 {

    /*
        打印实心菱形、空心菱形
                    总行数 4

                    行号          空格数         *数
@@@*                  1             3           1
@@***                 2             2           3
@*****                3             1           5
*******               4             0           7

    已知条件：总行数， 行号
    未知条件：
        空格数 = 总行数 - 行号
         *数 =  2*行号 - 1







 *****
  ***
   *
     */
    public static void main(String[] args) {
        printDiam();
    }

    public static void printDiam(){
        //循环 行号  i就是行号
        for (int i = 1; i <= 4 ; i++) {
            //每一行的空格是 4 - i个
            for (int j = 1; j <= 4 -i ; j++) {
                System.out.print(" ");
            }
            //每一行的*   2*i -1
            for (int j = 1; j <= 2*i - 1; j++) {
                if(j == 1 || (j == (2*i - 1))){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            //换行
            System.out.println();
        }
        //循环 行号  i就是行号
        for (int i = 3; i >= 1 ; i--) {
            //每一行的空格是 4 - i个
            for (int j = 1; j <= 4 -i ; j++) {
                System.out.print(" ");
            }
            //每一行的*   2*i -1
            for (int j = 1; j <= 2*i - 1; j++) {
                if(j == 1 || (j == (2*i - 1))){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            //换行
            System.out.println();
        }
    }
}
