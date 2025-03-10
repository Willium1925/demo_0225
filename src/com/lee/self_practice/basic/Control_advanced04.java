package com.lee.self_practice.basic;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Control_advanced04 {
    /*
    丟出例外的撰寫位置，除了放在try catch之外，也可直接寫在程式區塊，也可直接寫在方法先告
    public static void method() throws IOException {
        we5f4w3e1f3w5e1;
        throws IOException {
            evr56e51r651e5rv1
        };
    }
     */

    public static void main(String[] args) {
        salaryCounter03();
    }
    /*
    輸入便利商店工讀生的時數，並計算其薪資
    60小時以內，時薪120元
    61-80小時，以時薪1.25倍計算
    81小時以上，以時薪1.5倍計算
    說明：薪資以累計的方式計算。若工時為90小時，則薪資為60120+ 201201.25 + 10120*1.5 元
    */
    static void salaryCounter() {
        System.out.println("請輸入時數（正整數）");

        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                int hour = sc.nextInt();
                double salary = 0;
                String h = "h";
                if (hour <=0) {
                    System.out.println("時數不可小於等於零");
                } else if (hour <= 60) {
                    h = "A";
                } else if (/*hour>=61 &*/ hour<=80) {
                    h = "B";
                } else /*if (hour>=81)*/ {
                    h = "C";
                }
                switch (h) {
                    case "A":
                        salary = 120*hour;
                        break;
                    case "B":
                        salary = 120*60+120*1.25*hour;
                        break;
                    case "C":
                        salary = 120*60+120*1.25*20+120*1.5*hour;
                        break;
                    default:
                        //System.out.println("阿巴阿巴");
                }
                System.out.println("總時數為" + hour + "，總薪資為：" + salary);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("請輸入正確時數");
            }
        }

    }

    static void salaryCounter02() {
        System.out.println("02版運作，請輸入時數（正整數），或輸入e結束");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInsert = sc.nextLine();
            try {
                int hour = Integer.parseInt(userInsert);
                double salary = 0;
                String h = "h";
                if (hour <=0) {
                    System.out.println("時數不可小於等於零");
                } else if (hour <= 60) {
                    h = "A";
                } else if (/*hour>=61 &&*/ hour<=80) {
                    h = "B";
                } else /*if (hour>=81)*/ {
                    h = "C";
                }
                switch (h) {
                    case "A":
                        salary = 120*hour;
                        break;
                    case "B":
                        salary = 120*60 + 120*1.25*(hour-60);
                        break;
                    case "C":
                        salary = 120*60 + 120*1.25*20 + 120*1.5*(hour-80);
                        break;
                    default:
                        //System.out.println("阿巴阿巴");
                }
                System.out.println("狀況為" + h + "，總時數為" + hour + "，總薪資為：" + salary);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("請輸入正確時數");
            }
        }

    }

    static void salaryCounter03() {
        System.out.println("03版運作，請輸入時數");
        Scanner sc = new Scanner(System.in);

        try {
            if (!sc.hasNextInt()) {
                System.out.println("請輸入整數");
            } else {
                int userInsert = sc.nextInt();
                double salary = 0;
                if (userInsert <= 0) {
                    System.out.println("不可為零");
                } else if (userInsert <= 60) {
                    salary = userInsert*120;
                    System.out.println(salary);
                } else if (userInsert <= 80) {
                    salary = 60*120 + (userInsert-60)*120*1.25;
                    System.out.println(salary);
                } else {
                    salary = 60*120 + 20*120*1.25 + (userInsert-80)*120*1.5;
                    System.out.println(salary);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("請勿輸入其他字元");
        }


    }

}
