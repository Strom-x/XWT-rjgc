package SY2;

import java.io.*;
import java.util.Scanner;
public class ChangeFile {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("输入“1”开始输出：");
        int userNum = input.nextInt();
        if (userNum==1) {
            Print print = new Print();
            print.print();
        }else {
            System.out.println("即将退出程序");
            System.exit(0);
        }


    }
}
