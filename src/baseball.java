// package 폴더명
package com.company;

// 자바는 ;를 필수로 적어야 함
// 필요한 패키지 가져오기

import com.sun.source.tree.BreakTree;

import java.util.Random; // pandas에서 random 의 개념
import java.util.Scanner;

// public class 파일명{파이썬에서 함수 만드는 개념}
public class baseball {
    // def 개념
    // public static void main 함수가 있어야 자바프로그램을 실행가능
    public static void main(String[] args) {
        // import 개념
        // 객체 인스턴스화(객체 선언)
        Scanner sc = new Scanner(System.in);   // input 개념
        Random rand = new Random();
        int[] n = new int[3];
        int[] guess = new int[3];
        boolean[] already = new boolean[10];
        int strike, ball;

        // 야구 게임 코드화
        // for (변수 초기화(생략가능); 조건식; 증감연산)
        for (int i = 0; i < 10; i++) {
            already[i] = false;
        }
        int count = 0;
        while (count < 3) {
            int trial = rand.nextInt(10);
            if (!already[trial]) {
                n[count] = trial;
                already[trial] = true;
                count++;
            }
        }

        // 메인 코드
        boolean finish = false;
        while (!finish) { // while(true)
            strike = ball = 0;
            System.out.println("0-9 사이의 세 정수를 입력하세요.... >> ");
            for (int k = 0; k < 3; k++) {
                guess[k] = sc.nextInt();

                for (int j = 0; j < 3; j++) {
                    if (guess[k] == n[j]) {
                        if (k == j) strike++;
                        else ball++;
                    }
                }
            }
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
            if (strike == 3) {
                finish = true;
            }
        }
        sc.close();
        for (int j = 0; j < 3; j++) {
            System.out.println(n[j] + " ");
        }
        System.out.println(": 축하합니다!");
    }
}


